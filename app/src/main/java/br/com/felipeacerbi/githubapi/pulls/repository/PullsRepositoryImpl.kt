package br.com.felipeacerbi.githubapi.pulls.repository

import br.com.felipeacerbi.githubapi.network.api.GitHubApi
import br.com.felipeacerbi.githubapi.pulls.model.Pull
import io.reactivex.Single
import javax.inject.Inject

class PullsRepositoryImpl @Inject constructor(private val api: GitHubApi) : PullsRepository {
    override fun getPulls(owner: String, repo: String): Single<List<Pull>> =
            api.fetchPulls(owner, repo).map {
                it.map {
                    Pull (
                            it.title,
                            it.body,
                            it.user.login,
                            it.user.avatarUrl,
                            it.createdAt
                    )
                }
            }
}