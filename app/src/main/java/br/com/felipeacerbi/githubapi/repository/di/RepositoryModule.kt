package br.com.felipeacerbi.githubapi.repository.di

import br.com.felipeacerbi.githubapi.repository.pulls.PullsRepository
import br.com.felipeacerbi.githubapi.repository.pulls.PullsRepositoryImpl
import br.com.felipeacerbi.githubapi.repository.repos.ReposRepository
import br.com.felipeacerbi.githubapi.repository.repos.ReposRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideReposRepository(repository: ReposRepositoryImpl) : ReposRepository = repository

    @Provides
    @Singleton
    fun providePullsRepository(repository: PullsRepositoryImpl) : PullsRepository = repository

}