package br.com.felipeacerbi.githubapi.repository.pulls

import br.com.felipeacerbi.githubapi.repository.dtomodels.PullsResponse
import br.com.felipeacerbi.githubapi.repository.network.GitHubApi
import io.reactivex.Single
import javax.inject.Inject

class PullsRemoteDataSource @Inject constructor(private val api: GitHubApi) : PullsDataSource {

    override fun getPulls(owner: String, repo: String): Single<List<PullsResponse>> {
        return api.fetchPulls(owner, repo)
    }

    override fun refreshPulls() {
        // Not needed here
    }
}