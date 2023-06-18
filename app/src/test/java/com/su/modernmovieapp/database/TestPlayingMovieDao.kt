package com.su.modernmovieapp.database

import com.su.modernmovieapp.localstorage.dao.PlayingMovieDao
import com.su.modernmovieapp.localstorage.entity.PlayingMovieEntity
import com.su.modernmovieapp.util.MockUtil.createPlayingMovieEntity
import kotlinx.coroutines.flow.MutableStateFlow

class TestPlayingMovieDao : PlayingMovieDao {
    private var playingMoviesStateFlow = MutableStateFlow(
        listOf(
            createPlayingMovieEntity()
        )
    )

    override suspend fun insertPlayingMovies(companyListingEntities: List<PlayingMovieEntity>) {
        playingMoviesStateFlow.tryEmit(companyListingEntities)
    }

    override suspend fun searchPlayingMovie(movieId: Int): PlayingMovieEntity {
        return playingMoviesStateFlow.value.first { entity -> entity.id == movieId }
    }

    override suspend fun getAllPlayingMovies(): List<PlayingMovieEntity> {
        return playingMoviesStateFlow.value
    }

}