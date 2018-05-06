package br.com.felipeacerbi.githubapi.repos.repository

import br.com.felipeacerbi.githubapi.network.api.GitHubApi
import br.com.felipeacerbi.githubapi.network.utils.Mapper
import br.com.felipeacerbi.githubapi.repos.model.Repo
import io.reactivex.Single
import javax.inject.Inject

class ReposRepositoryImpl @Inject constructor(
        private val api: GitHubApi,
        private val mapper: Mapper
) : ReposRepository {
    override fun getRepos(language: String, page: Int): Single<List<Repo>> =
            api.fetchRepos(language, page).map(mapper::map)
}