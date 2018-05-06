package br.com.felipeacerbi.githubapi.app.di

import br.com.felipeacerbi.githubapi.pulls.di.PullsModule
import br.com.felipeacerbi.githubapi.pulls.view.PullsActivity
import br.com.felipeacerbi.githubapi.repos.di.ReposModule
import br.com.felipeacerbi.githubapi.repos.view.ReposActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindings {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ReposModule::class, FragmentBindings::class])
    abstract fun bindReposActivity(): ReposActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [PullsModule::class])
    abstract fun bindPullsActivity(): PullsActivity
}