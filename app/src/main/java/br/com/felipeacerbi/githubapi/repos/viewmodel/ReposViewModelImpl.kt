package br.com.felipeacerbi.githubapi.repos.viewmodel

import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.repos.interactors.ReposUseCase
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.actor

class ReposViewModelImpl (
        private val reposUseCase: ReposUseCase
) : ReposViewModel(reposUseCase) {

    private val actor = actor<Action>(UI, Channel.CONFLATED) {
        for(action in this) when (action) {
            is Action.FetchRepos -> {
                state.value = State.ShowLoading

                reposUseCase.execute(action.language, action.page).let {
                    onReposFetched(it)
                }
            }
        }
    }

    private fun onReposFetched(result: Result?) {
        when(result) {
            is Result.OnSuccess<*> -> {
                state.value = State.ItemsLoaded(result.items)
                state.value = State.ShowContent
            }
            is Result.OnError -> state.value = State.ShowError
        }
    }

    override fun performAction(action: Action) {
        actor.offer(action)
    }
}