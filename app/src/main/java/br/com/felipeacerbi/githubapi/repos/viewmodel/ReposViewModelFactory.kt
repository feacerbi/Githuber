package br.com.felipeacerbi.githubapi.repos.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.felipeacerbi.githubapi.repos.interactors.ReposUseCase
import javax.inject.Inject

class ReposViewModelFactory @Inject constructor(
        private val reposUseCase: ReposUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ReposViewModelImpl(reposUseCase) as T
    }
}