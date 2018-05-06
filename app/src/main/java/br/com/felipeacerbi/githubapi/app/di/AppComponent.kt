package br.com.felipeacerbi.githubapi.app.di

import br.com.felipeacerbi.githubapi.app.application.App
import br.com.felipeacerbi.githubapi.network.di.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBindings::class,
    NetworkModule::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}