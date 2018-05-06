package br.com.felipeacerbi.githubapi.pulls.interactors

import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.base.interactors.UseCase

interface PullsUseCase : UseCase {

    suspend fun execute(owner: String, repo: String): Result

}