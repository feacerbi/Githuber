package br.com.felipeacerbi.githubapi.pulls.viewmodel

import android.arch.lifecycle.MutableLiveData
import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.pulls.interactors.PullsUseCase
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.actor
import kotlin.coroutines.experimental.CoroutineContext

class PullsViewModelImpl (
        private val pullsUseCase: PullsUseCase,
        private val thisState: MutableLiveData<State> = MutableLiveData(),
        context: CoroutineContext = UI
) : PullsViewModel(pullsUseCase, thisState) {

    private val actor = actor<Action>(context, Channel.CONFLATED) {
        for (action in this) when (action) {
            is Action.FetchPulls -> {
                thisState.value = State.ShowLoading

                pullsUseCase.execute(action.owner, action.repo).let {
                    onPullsFetched(it)
                }
            }
        }
    }

    private fun onPullsFetched(result: Result?) {
        when(result) {
            is Result.OnSuccess<*> -> {
                thisState.value = State.ItemsLoaded(result.items)
                thisState.value = State.ShowContent
            }
            is Result.OnError -> thisState.value = State.ShowError
        }
    }

    override fun performAction(action: Action) {
        actor.offer(action)
    }

    override fun onCleared() {
        super.onCleared()
        actor.close()
    }
}