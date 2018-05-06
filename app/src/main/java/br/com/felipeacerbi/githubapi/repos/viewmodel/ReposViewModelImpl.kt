package br.com.felipeacerbi.githubapi.repos.viewmodel

import android.arch.lifecycle.MutableLiveData
import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.repos.interactors.ReposUseCase
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.actor
import kotlin.coroutines.experimental.CoroutineContext

class ReposViewModelImpl (
        private val reposUseCase: ReposUseCase,
        private val thisState: MutableLiveData<State> = MutableLiveData(),
        context: CoroutineContext = UI
) : ReposViewModel(reposUseCase, thisState) {

    private val actor = actor<Action>(context, Channel.CONFLATED) {
        for(action in this) when (action) {
            is Action.FetchRepos -> {
                thisState.value = State.ShowLoading

                reposUseCase.execute(action.language, action.page).let {
                    onReposFetched(it)
                }
            }
        }
    }

    private fun onReposFetched(result: Result?) {
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
}