package br.com.felipeacerbi.githubapi.viewmodel.di

import android.arch.lifecycle.ViewModelProviders
import br.com.felipeacerbi.githubapi.view.pulls.PullsActivity
import br.com.felipeacerbi.githubapi.view.repos.ReposActivity
import br.com.felipeacerbi.githubapi.viewmodel.pulls.PullsViewModel
import br.com.felipeacerbi.githubapi.viewmodel.pulls.PullsViewModelFactory
import br.com.felipeacerbi.githubapi.viewmodel.repos.ReposViewModel
import br.com.felipeacerbi.githubapi.viewmodel.repos.ReposViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun provideReposViewModel(activity: ReposActivity, factory: ReposViewModelFactory): ReposViewModel {
        return ViewModelProviders.of(activity, factory).get(ReposViewModel::class.java)
    }

    @Provides
    @Singleton
    fun providePullsViewModel(activity: PullsActivity, factory: PullsViewModelFactory): PullsViewModel {
        return ViewModelProviders.of(activity, factory).get(PullsViewModel::class.java)
    }
}