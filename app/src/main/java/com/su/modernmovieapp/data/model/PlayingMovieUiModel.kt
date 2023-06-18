package com.su.modernmovieapp.data.model


data class PlayingMovieUiModel(
    val id: Int,
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val overview: String,
    val releaseDate: String,
    val backdropPath: String
)