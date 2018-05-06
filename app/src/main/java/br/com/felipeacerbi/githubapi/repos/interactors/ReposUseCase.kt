package br.com.felipeacerbi.githubapi.repos.interactors

import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.base.interactors.UseCase

interface ReposUseCase : UseCase {

    suspend fun execute(language: String, page: Int): Result

}