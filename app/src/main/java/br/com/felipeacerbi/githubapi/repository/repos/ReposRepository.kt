package br.com.felipeacerbi.githubapi.repository.repos

import br.com.felipeacerbi.githubapi.repository.dtomodels.Item
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReposRepository @Inject constructor(val reposRemoteDataSource: ReposDataSource) : ReposDataSource {

    var cachedRepos: LinkedHashMap<Int, Item> = LinkedHashMap()
    var cacheDirty = false

    override fun getRepos(language: String, page: Int): Single<List<Item>> {
        return if(!cacheDirty && cachedRepos.isNotEmpty()) {
            Single.just(ArrayList(cachedRepos.values))
        } else {
            getReposFromRemoteDataSource(language, page)
        }
    }

    override fun refreshRepos() {
        cacheDirty = true
    }

    private fun getReposFromRemoteDataSource(language: String, page: Int): Single<List<Item>> {
        return reposRemoteDataSource.getRepos(language, page).doAfterSuccess {
            refreshCache(it)
        }
    }

    private fun refreshCache(repos: List<Item>) {
        cachedRepos.clear()
        repos.forEach {
            cachedRepos[it.id] = it
        }
        cacheDirty = false
    }
}