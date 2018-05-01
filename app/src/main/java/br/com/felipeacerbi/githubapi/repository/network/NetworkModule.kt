package br.com.felipeacerbi.githubapi.repository.network

import br.com.felipeacerbi.githubapi.BuildConfig
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
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
    fun provideGitHubApi(builder: Retrofit.Builder,
                         okHttpBuilder: OkHttpClient.Builder,
                         httpLoggingInterceptor: HttpLoggingInterceptor,
                         converterFactory: Converter.Factory): GitHubApi {

        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addNetworkInterceptor(httpLoggingInterceptor)
        }

        return builder.client(okHttpBuilder.build())
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(converterFactory)
                .build()
                .create(GitHubApi::class.java)
    }

}