package br.com.felipeacerbi.githubapi.viewmodel.repos

import br.com.felipeacerbi.githubapi.viewmodel.base.BaseViewModel

abstract class ReposViewModel : BaseViewModel() {

    sealed class Action {
        data class FetchRepos(val language: String, val page: Int) : Action()
    }

    abstract fun performAction(action: Action)
}