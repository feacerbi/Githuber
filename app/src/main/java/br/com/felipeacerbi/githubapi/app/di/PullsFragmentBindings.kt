package br.com.felipeacerbi.githubapi.app.di

import br.com.felipeacerbi.githubapi.pulls.di.PullsFragmentModule
import br.com.felipeacerbi.githubapi.pulls.view.PullsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PullsFragmentBindings {

    @FragmentScope
    @ContributesAndroidInjector(modules = [PullsFragmentModule::class])
    abstract fun contributePullsFragment(): PullsListFragment

}