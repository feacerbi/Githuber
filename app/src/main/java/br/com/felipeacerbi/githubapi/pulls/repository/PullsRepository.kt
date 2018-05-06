package br.com.felipeacerbi.githubapi.pulls.repository

import br.com.felipeacerbi.githubapi.pulls.model.Pull
import io.reactivex.Single

interface PullsRepository {
    fun getPulls(owner: String, repo: String) : Single<List<Pull>>
}