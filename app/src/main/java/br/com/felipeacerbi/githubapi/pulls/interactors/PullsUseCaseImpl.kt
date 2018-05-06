package br.com.felipeacerbi.githubapi.pulls.interactors

import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase
import br.com.felipeacerbi.githubapi.pulls.repository.PullsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PullsUseCaseImpl @Inject constructor(
        private val pullsRepository: PullsRepository
) : BaseUseCase(), PullsUseCase {

    override suspend fun execute(owner: String, repo: String): Result =
            pullsRepository.getPulls(owner, repo)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .retrieve()
}