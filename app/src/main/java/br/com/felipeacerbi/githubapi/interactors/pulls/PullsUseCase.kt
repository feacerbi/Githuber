package br.com.felipeacerbi.githubapi.interactors.pulls

import br.com.felipeacerbi.githubapi.interactors.base.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.interactors.base.UseCase

interface PullsUseCase : UseCase {

    suspend fun execute(owner: String, repo: String): Result

}