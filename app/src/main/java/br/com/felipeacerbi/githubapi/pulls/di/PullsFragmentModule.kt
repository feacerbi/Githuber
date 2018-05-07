package br.com.felipeacerbi.githubapi.pulls.di

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProviders
import br.com.felipeacerbi.githubapi.app.di.FragmentScope
import br.com.felipeacerbi.githubapi.base.viewmodel.BaseViewModel.State
import br.com.felipeacerbi.githubapi.pulls.view.PullsListFragment
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel.Action
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModelFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

@Module
class PullsFragmentModule {

    @Provides
    @FragmentScope
    fun providePullsViewModel(fragment: PullsListFragment, factory: PullsViewModelFactory): PullsViewModel {
        return ViewModelProviders.of(fragment, factory).get(PullsViewModel::class.java)
    }

    @Provides
    @FragmentScope
    fun provideStateLiveData(): MutableLiveData<State> = MutableLiveData()

    @Provides
    @FragmentScope
    fun provideCoroutineContext(): CoroutineContext = UI

    @Provides
    @FragmentScope
    fun provideActionLiveData(): MutableLiveData<Action> = MutableLiveData()
}