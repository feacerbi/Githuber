package br.com.felipeacerbi.githubapi.viewmodel.pulls

import br.com.felipeacerbi.githubapi.viewmodel.base.BaseViewModel

abstract class PullsViewModel : BaseViewModel() {

    sealed class Action {
        data class FetchPulls(val owner: String, val repo: String) : Action()
    }

    abstract fun performAction(action: Action)
}