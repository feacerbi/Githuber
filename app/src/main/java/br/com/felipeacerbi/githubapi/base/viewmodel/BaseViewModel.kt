package br.com.felipeacerbi.githubapi.base.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.felipeacerbi.githubapi.base.interactors.UseCase

abstract class BaseViewModel(
        private val useCase: UseCase,
        val state: MutableLiveData<State> = MutableLiveData()
) : ViewModel() {

    sealed class State {
        data class ItemsLoaded<T>(val items: List<T>) : State()
        object ShowLoading : State()
        object ShowContent : State()
        object ShowError : State()
    }

    fun getState(): LiveData<State> = state

    override fun onCleared() {
        useCase.cleanUp()
        super.onCleared()
    }
}