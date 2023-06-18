package com.su.modernmovieapp.di

import com.su.modernmovieapp.network.NetworkDataSource
import com.su.modernmovieapp.network.retrofit.MovieApi
import com.su.modernmovieapp.network.retrofit.RetrofitMovieApiFactory
import com.su.modernmovieapp.network.retrofit.RetrofitNetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideMovieApi(): MovieApi {
        return RetrofitMovieApiFactory.movieApi
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(movieApi: MovieApi): NetworkDataSource = RetrofitNetworkDataSource(movieApi)

}