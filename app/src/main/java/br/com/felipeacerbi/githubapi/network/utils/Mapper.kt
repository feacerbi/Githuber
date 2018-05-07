package br.com.felipeacerbi.githubapi.network.utils

import br.com.felipeacerbi.githubapi.network.model.PullsResponse
import br.com.felipeacerbi.githubapi.network.model.ReposResponse
import br.com.felipeacerbi.githubapi.pulls.model.Pull
import br.com.felipeacerbi.githubapi.repos.model.Repo
import javax.inject.Inject

class Mapper @Inject constructor() {
    fun map(response: ReposResponse): List<Repo> {
        return response.items.map {
            Repo(
                    it.name,
                    it.description,
                    it.owner.login,
                    it.owner.avatarUrl,
                    it.stargazersCount,
                    it.forksCount)
        }
    }

    fun map(response: List<PullsResponse>): List<Pull> {
        return response.map {
            Pull (
                    it.title,
                    it.body,
                    it.user.login,
                    it.user.avatarUrl,
                    it.createdAt,
                    it.htmlUrl
            )
        }
    }
}