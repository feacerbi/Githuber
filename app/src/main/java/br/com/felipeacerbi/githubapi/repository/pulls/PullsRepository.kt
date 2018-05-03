package br.com.felipeacerbi.githubapi.repository.pulls

import br.com.felipeacerbi.githubapi.network.model.PullsResponse
import io.reactivex.Single

interface PullsRepository {
    fun getPulls(owner: String, repo: String) : Single<List<PullsResponse>>
}