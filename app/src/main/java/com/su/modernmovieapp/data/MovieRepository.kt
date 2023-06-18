package com.su.modernmovieapp.data

import com.su.modernmovieapp.data.model.PlayingMovieUiModel
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPlayingMovie(): Flow<List<PlayingMovieUiModel>>
    fun findPlayingMovieDetail(movieId:Int): Flow<PlayingMovieUiModel>
}