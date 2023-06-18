package com.su.modernmovieapp.di

import android.app.Application
import androidx.room.Room
import com.su.modernmovieapp.localstorage.MovieDatabase
import com.su.modernmovieapp.localstorage.dao.PlayingMovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): MovieDatabase =
        Room.databaseBuilder(application, MovieDatabase::class.java, "movie.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providePlayingMovieDao(database: MovieDatabase): PlayingMovieDao{
        return database.playingMovieDao()
    }
}