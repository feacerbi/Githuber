package br.com.felipeacerbi.githubapi.repository.repos

import br.com.felipeacerbi.githubapi.network.api.GitHubApi
import br.com.felipeacerbi.githubapi.network.model.Item
import io.reactivex.Single
import javax.inject.Inject

class ReposRepositoryImpl @Inject constructor(private val api: GitHubApi) : ReposRepository {
    override fun getRepos(language: String, page: Int): Single<List<Item>> =
            api.fetchRepos(language, page).map {
                it.items.map { it }
            }
}