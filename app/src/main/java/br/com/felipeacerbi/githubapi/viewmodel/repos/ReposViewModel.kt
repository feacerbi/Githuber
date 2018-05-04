package br.com.felipeacerbi.githubapi.viewmodel.repos

import br.com.felipeacerbi.githubapi.interactors.base.UseCase
import br.com.felipeacerbi.githubapi.viewmodel.base.BaseViewModel

abstract class ReposViewModel(useCase: UseCase) : BaseViewModel(useCase) {

    sealed class Action {
        data class FetchRepos(val language: String, val page: Int) : Action()
    }

    abstract fun performAction(action: Action)
}