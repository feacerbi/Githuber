package br.com.felipeacerbi.githubapi.viewmodel.repos

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.felipeacerbi.githubapi.interactors.repos.ReposUseCaseImpl
import javax.inject.Inject

class ReposViewModelFactory @Inject constructor(
        private val reposUseCaseImpl: ReposUseCaseImpl
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ReposViewModelImpl(reposUseCaseImpl) as T
    }
}