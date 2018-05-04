package br.com.felipeacerbi.githubapi.viewmodel.pulls

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.felipeacerbi.githubapi.interactors.pulls.PullsUseCase
import javax.inject.Inject

class PullsViewModelFactory @Inject constructor(
        private val pullsUseCase: PullsUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PullsViewModelImpl(pullsUseCase) as T
    }
}