package br.com.felipeacerbi.githubapi.viewmodel.repos

import android.arch.lifecycle.LiveData
import br.com.felipeacerbi.githubapi.interactors.repos.ReposUseCaseImpl
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.actor

class ReposViewModelImpl (
        private val useCaseImpl: ReposUseCaseImpl
) : ReposViewModel() {

    private val actor = actor<Action>(UI, Channel.CONFLATED) {
        for (action in this) when (action) {
            is Action.FetchRepos -> {
                state.value = State.ShowLoading

                useCaseImpl.execute(action.language, action.page).let {
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