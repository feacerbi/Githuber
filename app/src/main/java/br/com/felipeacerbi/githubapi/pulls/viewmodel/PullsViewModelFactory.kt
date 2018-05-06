package br.com.felipeacerbi.githubapi.pulls.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.felipeacerbi.githubapi.base.viewmodel.BaseViewModel
import br.com.felipeacerbi.githubapi.pulls.interactors.PullsUseCase
import javax.inject.Inject
import kotlin.coroutines.experimental.CoroutineContext

class PullsViewModelFactory @Inject constructor(
        private val pullsUseCase: PullsUseCase,
        private val state: MutableLiveData<BaseViewModel.State>,
        private val context: CoroutineContext
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PullsViewModelImpl(pullsUseCase, state, context) as T
    }
}