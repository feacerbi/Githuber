package br.com.felipeacerbi.githubapi.repos.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.felipeacerbi.githubapi.base.viewmodel.BaseViewModel
import br.com.felipeacerbi.githubapi.repos.interactors.ReposUseCase
import javax.inject.Inject
import kotlin.coroutines.experimental.CoroutineContext

class ReposViewModelFactory @Inject constructor(
        private val reposUseCase: ReposUseCase,
        private val state: MutableLiveData<BaseViewModel.State>,
        private val context: CoroutineContext
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ReposViewModelImpl(reposUseCase, state, context) as T
    }
}