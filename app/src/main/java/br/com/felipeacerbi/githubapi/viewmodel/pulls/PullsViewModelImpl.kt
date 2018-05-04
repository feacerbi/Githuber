package br.com.felipeacerbi.githubapi.viewmodel.pulls

import br.com.felipeacerbi.githubapi.interactors.base.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.interactors.pulls.PullsUseCase
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.actor

class PullsViewModelImpl (
        private val pullsUseCase: PullsUseCase
) : PullsViewModel(pullsUseCase) {

    private val actor = actor<Action>(UI, Channel.CONFLATED) {
        for (action in this) when (action) {
            is Action.FetchPulls -> {
                state.value = State.ShowLoading

                pullsUseCase.execute(action.owner, action.repo).let {
                    onPullsFetched(it)
                }
            }
        }
    }

    private fun onPullsFetched(result: Result?) {
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