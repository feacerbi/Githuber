package br.com.felipeacerbi.githubapi.viewmodel.pulls

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.felipeacerbi.githubapi.interactors.pulls.PullsUseCaseImpl
import javax.inject.Inject

class PullsViewModelFactory @Inject constructor(
        private val pullsUseCaseImpl: PullsUseCaseImpl
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PullsViewModelImpl(pullsUseCaseImpl) as T
    }
}