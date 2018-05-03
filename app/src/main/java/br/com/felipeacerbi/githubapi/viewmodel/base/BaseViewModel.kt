package br.com.felipeacerbi.githubapi.viewmodel.base

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.felipeacerbi.githubapi.interactors.base.BaseUseCase.Result

abstract class BaseViewModel(
        val state: MutableLiveData<State> = MutableLiveData()
) : ViewModel() {

    sealed class State {
        data class ItemsLoaded<T>(val items: List<T>) : State()
        object ShowLoading : State()
        object ShowContent : State()
        object ShowError : State()
    }

    fun onItemsFetched(result: Result?) {
        when(result) {
            is Result.OnSuccess<*> -> {
                state.value = State.ItemsLoaded(result.items)
                state.value = State.ShowContent
            }
            is Result.OnError -> state.value = State.ShowError
        }
    }

    abstract fun getState(): LiveData<State>
}