package br.com.felipeacerbi.githubapi.interactors.repos

import br.com.felipeacerbi.githubapi.interactors.base.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.interactors.base.UseCase

interface ReposUseCase : UseCase {

    suspend fun execute(language: String, page: Int): Result

}