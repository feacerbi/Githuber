package br.com.felipeacerbi.githubapi.repos.repository

import br.com.felipeacerbi.githubapi.repos.model.Repo
import io.reactivex.Single

interface ReposRepository {
    fun getRepos(language: String, page: Int) : Single<List<Repo>>
}