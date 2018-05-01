package br.com.felipeacerbi.githubapi.repository.pulls

import br.com.felipeacerbi.githubapi.repository.dtomodels.PullsResponse
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PullsRepository @Inject constructor(val pullsRemoteDataSource: PullsRemoteDataSource) : PullsDataSource {

    var cachedPulls: LinkedHashMap<Int, PullsResponse> = LinkedHashMap()
    var cacheDirty = false

    override fun getPulls(owner: String, repo: String): Single<List<PullsResponse>> {
        return if(!cacheDirty && cachedPulls.isNotEmpty()) {
            Single.just(ArrayList(cachedPulls.values))
        } else {
            getReposFromRemoteDataSource(owner, repo)
        }
    }

    override fun refreshPulls() {
        cacheDirty = true
    }

    private fun getReposFromRemoteDataSource(owner: String, repo: String): Single<List<PullsResponse>> {
        return pullsRemoteDataSource.getPulls(owner, repo).doAfterSuccess {
            refreshCache(it)
        }
    }

    private fun refreshCache(repos: List<PullsResponse>) {
        cachedPulls.clear()
        repos.forEach {
            cachedPulls[it.id] = it
        }
        cacheDirty = false
    }
}