package com.su.modernmovieapp.localstorage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.su.modernmovieapp.localstorage.entity.PlayingMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayingMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayingMovies(
        companyListingEntities: List<PlayingMovieEntity>
    )

    @Query("SELECT * FROM PlayingMovieEntity WHERE `id` = :movieId")
    suspend fun searchPlayingMovie(movieId:Int): PlayingMovieEntity


    @Query("SELECT * FROM PlayingMovieEntity")
    suspend fun getAllPlayingMovies(): List<PlayingMovieEntity>

}