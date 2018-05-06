package br.com.felipeacerbi.githubapi.app.di

import br.com.felipeacerbi.githubapi.repos.view.ReposFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindings {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeReposFragment(): ReposFragment

}