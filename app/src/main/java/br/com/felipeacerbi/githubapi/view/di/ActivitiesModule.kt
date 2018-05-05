package br.com.felipeacerbi.githubapi.view.di

import br.com.felipeacerbi.githubapi.view.pulls.PullsActivity
import br.com.felipeacerbi.githubapi.view.repos.ReposActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = [(FragmentsModule::class)])
    abstract fun contributeReposActivity(): ReposActivity

    @ContributesAndroidInjector
    abstract fun contributePullsActivity(): PullsActivity

}