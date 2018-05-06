package br.com.felipeacerbi.githubapi.pulls.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.felipeacerbi.githubapi.pulls.interactors.PullsUseCase
import javax.inject.Inject

class PullsViewModelFactory @Inject constructor(
        private val pullsUseCase: PullsUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PullsViewModelImpl(pullsUseCase) as T
    }
}