package br.com.felipeacerbi.githubapi.repos.interactors

import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase
import br.com.felipeacerbi.githubapi.repos.repository.ReposRepository
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ReposUseCaseImpl @Inject constructor(
        private val reposRepository: ReposRepository
) : BaseUseCase(), ReposUseCase {

    override suspend fun execute(language: String, page: Int): Result =
            reposRepository.getRepos(language, page)
                    .subscribeOn(Schedulers.io())
                    .retrieve()

}