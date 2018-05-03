package br.com.felipeacerbi.githubapi.viewmodel.di

import android.arch.lifecycle.ViewModelProviders
import br.com.felipeacerbi.githubapi.MainActivity
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
    fun provideReposViewModel(activity: MainActivity, factory: ReposViewModelFactory): ReposViewModel {
        return ViewModelProviders.of(activity, factory).get(ReposViewModel::class.java)
    }

    @Provides
    @Singleton
    fun providePullsViewModel(activity: MainActivity, factory: PullsViewModelFactory): PullsViewModel {
        return ViewModelProviders.of(activity, factory).get(PullsViewModel::class.java)
    }
}