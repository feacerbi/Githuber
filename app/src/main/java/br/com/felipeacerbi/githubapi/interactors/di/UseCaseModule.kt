package br.com.felipeacerbi.githubapi.interactors.di

import br.com.felipeacerbi.githubapi.interactors.pulls.PullsUseCase
import br.com.felipeacerbi.githubapi.interactors.pulls.PullsUseCaseImpl
import br.com.felipeacerbi.githubapi.interactors.repos.ReposUseCase
import br.com.felipeacerbi.githubapi.interactors.repos.ReposUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideReposUseCase(reposUseCase: ReposUseCaseImpl): ReposUseCase = reposUseCase

    @Provides
    @Singleton
    fun providePullsUseCase(pullsUseCase: PullsUseCaseImpl): PullsUseCase = pullsUseCase
}