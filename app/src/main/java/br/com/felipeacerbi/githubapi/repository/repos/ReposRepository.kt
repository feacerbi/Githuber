package br.com.felipeacerbi.githubapi.repository.repos

import br.com.felipeacerbi.githubapi.network.model.Item
import io.reactivex.Single

interface ReposRepository {
    fun getRepos(language: String, page: Int) : Single<List<Item>>
}