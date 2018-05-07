package br.com.felipeacerbi.githubapi.pulls.di

import android.content.Context
import br.com.felipeacerbi.githubapi.app.di.ActivityScope
import br.com.felipeacerbi.githubapi.pulls.di.PullsModule.*
import br.com.felipeacerbi.githubapi.pulls.interactors.PullsUseCase
import br.com.felipeacerbi.githubapi.pulls.interactors.PullsUseCaseImpl
import br.com.felipeacerbi.githubapi.pulls.repository.PullsRepository
import br.com.felipeacerbi.githubapi.pulls.repository.PullsRepositoryImpl
import br.com.felipeacerbi.githubapi.pulls.view.PullsActivity
import dagger.Module
import dagger.Provides

@Module(includes = [
    Repository::class,
    UseCase::class,
    View::class
])
class PullsModule {

    @Module
    class Repository {
        @Provides
        @ActivityScope
        fun providePullsRepository(repository: PullsRepositoryImpl) : PullsRepository = repository
    }

    @Module
    class UseCase {
        @Provides
        @ActivityScope
        fun providePullsUseCase(pullsUseCase: PullsUseCaseImpl): PullsUseCase = pullsUseCase
    }

    @Module
    class View {
        @Provides
        @ActivityScope
        fun provideContext(activity: PullsActivity): Context = activity
    }
}