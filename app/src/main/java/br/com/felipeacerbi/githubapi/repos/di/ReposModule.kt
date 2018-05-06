package br.com.felipeacerbi.githubapi.repos.di

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import br.com.felipeacerbi.githubapi.app.di.ActivityScope
import br.com.felipeacerbi.githubapi.repos.di.ReposModule.*
import br.com.felipeacerbi.githubapi.repos.interactors.ReposUseCase
import br.com.felipeacerbi.githubapi.repos.interactors.ReposUseCaseImpl
import br.com.felipeacerbi.githubapi.repos.repository.ReposRepository
import br.com.felipeacerbi.githubapi.repos.repository.ReposRepositoryImpl
import br.com.felipeacerbi.githubapi.repos.view.ReposActivity
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel.Action
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModelFactory
import dagger.Module
import dagger.Provides

@Module(includes = [
    Repository::class,
    UseCase::class,
    ViewModel::class,
    View::class
])
class ReposModule {

    @Module
    class Repository {
        @Provides
        @ActivityScope
        fun provideReposRepository(repository: ReposRepositoryImpl) : ReposRepository = repository
    }

    @Module
    class UseCase {
        @Provides
        @ActivityScope
        fun provideReposUseCase(pullsUseCase: ReposUseCaseImpl): ReposUseCase = pullsUseCase
    }

    @Module
    class ViewModel {
        @Provides
        @ActivityScope
        fun provideReposViewModel(activity: ReposActivity, factory: ReposViewModelFactory): ReposViewModel {
            return ViewModelProviders.of(activity, factory).get(ReposViewModel::class.java)
        }
    }

    @Module
    class View {
        @Provides
        @ActivityScope
        fun provideContext(activity: ReposActivity): Context = activity

        @Provides
        @ActivityScope
        fun provideActionLiveData(): MutableLiveData<Action> = MutableLiveData()
    }
}