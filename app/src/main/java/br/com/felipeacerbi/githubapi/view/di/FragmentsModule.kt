package br.com.felipeacerbi.githubapi.view.di

import br.com.felipeacerbi.githubapi.view.repos.ReposFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeReposFragment(): ReposFragment

}