package br.com.felipeacerbi.githubapi.viewmodel.pulls

import android.arch.lifecycle.LiveData
import br.com.felipeacerbi.githubapi.interactors.pulls.PullsUseCaseImpl
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.actor

class PullsViewModelImpl (
        private val useCaseImpl: PullsUseCaseImpl
) : PullsViewModel() {

    private val actor = actor<Action>(UI, Channel.CONFLATED) {
        for (action in this) when (action) {
            is Action.FetchPulls -> {
                state.value = State.ShowLoading

                useCaseImpl.execute(action.owner, action.repo).let {
                    onItemsFetched(it)
                }
            }
        }
    }

    override fun getState(): LiveData<State> = state

    override fun performAction(action: Action) {
        actor.offer(action)
    }

    override fun onCleared() {
        super.onCleared()
        useCaseImpl.cleanUp()
    }
}