package br.com.felipeacerbi.githubapi.repos.di

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProviders
import br.com.felipeacerbi.githubapi.app.di.FragmentScope
import br.com.felipeacerbi.githubapi.base.viewmodel.BaseViewModel.State
import br.com.felipeacerbi.githubapi.repos.view.ReposListFragment
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel.Action
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModelFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

@Module
class ReposFragmentModule {

    @Provides
    @FragmentScope
    fun provideReposViewModel(fragment: ReposListFragment, factory: ReposViewModelFactory): ReposViewModel {
        return ViewModelProviders.of(fragment, factory).get(ReposViewModel::class.java)
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