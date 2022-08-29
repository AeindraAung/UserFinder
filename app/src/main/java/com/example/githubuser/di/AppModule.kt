package com.example.githubuser.di

import com.example.githubuser.data.remote.GithubUserApiService
import com.example.githubuser.data.remote.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return RetrofitFactory.createRetrofit(okHttpClient = client)
    }

    @Singleton
    @Provides
    fun provideOKHTTPClient(): OkHttpClient {
        return RetrofitFactory.provideOkHttpClient()
    }

    @Singleton
    @Provides
    fun provideCurrencyExchangeService(retrofit: Retrofit): GithubUserApiService {
        return retrofit.create()
    }
}