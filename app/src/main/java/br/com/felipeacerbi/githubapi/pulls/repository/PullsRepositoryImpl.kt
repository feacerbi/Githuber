package br.com.felipeacerbi.githubapi.pulls.repository

import br.com.felipeacerbi.githubapi.network.api.GitHubApi
import br.com.felipeacerbi.githubapi.network.utils.Mapper
import br.com.felipeacerbi.githubapi.pulls.model.Pull
import io.reactivex.Single
import javax.inject.Inject

class PullsRepositoryImpl @Inject constructor(
        private val api: GitHubApi,
        private val mapper: Mapper
) : PullsRepository {
    override fun getPulls(owner: String, repo: String): Single<List<Pull>> =
            api.fetchPulls(owner, repo).map(mapper::map)
}