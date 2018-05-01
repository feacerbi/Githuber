package br.com.felipeacerbi.githubapi.repository.repos

import br.com.felipeacerbi.githubapi.repository.dtomodels.Item
import io.reactivex.Single

interface ReposDataSource {

    fun getRepos(language: String, page: Int) : Single<List<Item>>

    fun refreshRepos()
}