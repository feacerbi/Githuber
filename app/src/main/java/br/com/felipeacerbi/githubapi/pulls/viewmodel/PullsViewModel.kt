package br.com.felipeacerbi.githubapi.pulls.viewmodel

import android.arch.lifecycle.MutableLiveData
import br.com.felipeacerbi.githubapi.base.interactors.UseCase
import br.com.felipeacerbi.githubapi.base.viewmodel.BaseViewModel
import br.com.felipeacerbi.githubapi.pulls.model.Pull

abstract class PullsViewModel(
        useCase: UseCase,
        state: MutableLiveData<State>
) : BaseViewModel(useCase, state) {

    sealed class Action {
        data class FetchPulls(val owner: String, val repo: String) : Action()
        data class ClickPull(val pull: Pull) : Action()
    }

    abstract fun performAction(action: Action)
}