package br.com.felipeacerbi.githubapi.repos.viewmodel

import br.com.felipeacerbi.githubapi.base.interactors.UseCase
import br.com.felipeacerbi.githubapi.base.viewmodel.BaseViewModel
import br.com.felipeacerbi.githubapi.repos.model.Repo

abstract class ReposViewModel(useCase: UseCase) : BaseViewModel(useCase) {

    sealed class Action {
        data class FetchRepos(val language: String, val page: Int) : Action()
        data class ClickRepo(val repo: Repo) : Action()
    }

    abstract fun performAction(action: Action)
}