package br.com.felipeacerbi.githubapi.network.di

import br.com.felipeacerbi.githubapi.BuildConfig
import br.com.felipeacerbi.githubapi.network.api.GitHubApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(): Converter.Factory = MoshiConverterFactory.create(Moshi.Builder().build())

    @Provides
    @Singleton
    fun provideCallAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())

    @Provides
    @Singleton
    fun provideGitHubApi(builder: Retrofit.Builder,
                         okHttpBuilder: OkHttpClient.Builder,
                         httpLoggingInterceptor: HttpLoggingInterceptor,
                         converterFactory: Converter.Factory,
                         callAdapterFactory: CallAdapter.Factory): GitHubApi {

        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addNetworkInterceptor(httpLoggingInterceptor)
        }

        return builder.client(okHttpBuilder.build())
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build()
                .create(GitHubApi::class.java)
    }

}