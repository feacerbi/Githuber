package br.com.felipeacerbi.githubapi.app.di

import br.com.felipeacerbi.githubapi.repos.di.ReposFragmentModule
import br.com.felipeacerbi.githubapi.repos.view.ReposListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ReposFragmentBindings {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ReposFragmentModule::class])
    abstract fun contributeReposFragment(): ReposListFragment

}