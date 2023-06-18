package com.su.modernmovieapp.di

import com.su.modernmovieapp.data.MovieRepository
import com.su.modernmovieapp.data.MovieRepositoryImpl
import com.su.modernmovieapp.localstorage.dao.PlayingMovieDao
import com.su.modernmovieapp.network.NetworkDataSource
import com.su.modernmovieapp.network.retrofit.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideMovieRepository(network: NetworkDataSource, playingMovieDao: PlayingMovieDao) : MovieRepository = MovieRepositoryImpl(network,playingMovieDao)
}