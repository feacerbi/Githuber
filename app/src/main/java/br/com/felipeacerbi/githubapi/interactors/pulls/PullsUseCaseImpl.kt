package br.com.felipeacerbi.githubapi.interactors.pulls

import br.com.felipeacerbi.githubapi.interactors.base.BaseUseCase
import br.com.felipeacerbi.githubapi.repository.pulls.PullsRepository
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