package br.com.felipeacerbi.githubapi.repos.repository

import br.com.felipeacerbi.githubapi.network.api.GitHubApi
import br.com.felipeacerbi.githubapi.repos.model.Repo
import io.reactivex.Single
import javax.inject.Inject

class ReposRepositoryImpl @Inject constructor(private val api: GitHubApi) : ReposRepository {
    override fun getRepos(language: String, page: Int): Single<List<Repo>> =
            api.fetchRepos(language, page).map {
                it.items.map {
                    Repo(
                            it.name,
                            it.description,
                            it.owner.login,
                            it.owner.avatarUrl,
                            it.stargazersCount,
                            it.forksCount)
                }
            }
}