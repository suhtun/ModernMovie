package com.su.modernmovieapp.localstorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.su.modernmovieapp.localstorage.dao.PlayingMovieDao
import com.su.modernmovieapp.localstorage.entity.PlayingMovieEntity


@Database(entities = [PlayingMovieEntity::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun playingMovieDao(): PlayingMovieDao
}