package br.com.felipeacerbi.githubapi.repository.repos

import br.com.felipeacerbi.githubapi.repository.dtomodels.Item
import br.com.felipeacerbi.githubapi.repository.network.GitHubApi
import io.reactivex.Single
import javax.inject.Inject

class ReposRemoteDataSource @Inject constructor(private val api: GitHubApi) : ReposDataSource {

    override fun getRepos(language: String, page: Int): Single<List<Item>> {
        return api.fetchRepos(language, page).flatMap {
            Single.just(it.items)
        }
    }

    override fun refreshRepos() {
        // Not needed here
    }
}