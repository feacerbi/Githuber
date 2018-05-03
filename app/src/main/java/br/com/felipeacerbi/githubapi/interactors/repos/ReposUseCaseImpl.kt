package br.com.felipeacerbi.githubapi.interactors.repos

import br.com.felipeacerbi.githubapi.interactors.base.BaseUseCase
import br.com.felipeacerbi.githubapi.repository.repos.ReposRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ReposUseCaseImpl @Inject constructor(
        private val reposRepository: ReposRepository
) : BaseUseCase(), ReposUseCase {

    override suspend fun execute(language: String, page: Int): Result =
            reposRepository.getRepos(language, page)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .retrieve()

}