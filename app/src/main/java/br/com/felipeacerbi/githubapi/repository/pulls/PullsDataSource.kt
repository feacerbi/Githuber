package br.com.felipeacerbi.githubapi.repository.pulls

import br.com.felipeacerbi.githubapi.repository.dtomodels.PullsResponse
import io.reactivex.Single

interface PullsDataSource {

    fun getPulls(owner: String, repo: String) : Single<List<PullsResponse>>

    fun refreshPulls()
}