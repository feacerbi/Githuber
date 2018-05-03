package br.com.felipeacerbi.githubapi.repository.pulls

import br.com.felipeacerbi.githubapi.network.api.GitHubApi
import br.com.felipeacerbi.githubapi.network.model.PullsResponse
import io.reactivex.Single
import javax.inject.Inject

class PullsRepositoryImpl @Inject constructor(private val api: GitHubApi) : PullsRepository {
    override fun getPulls(owner: String, repo: String): Single<List<PullsResponse>> = api.fetchPulls(owner, repo)
}