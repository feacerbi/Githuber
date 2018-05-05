package br.com.felipeacerbi.githubapi.app.di

import br.com.felipeacerbi.githubapi.app.App
import br.com.felipeacerbi.githubapi.interactors.di.UseCaseModule
import br.com.felipeacerbi.githubapi.network.di.NetworkModule
import br.com.felipeacerbi.githubapi.repository.di.RepositoryModule
import br.com.felipeacerbi.githubapi.view.di.ActivitiesModule
import br.com.felipeacerbi.githubapi.viewmodel.di.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivitiesModule::class,
    ViewModelModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    NetworkModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}