package com.su.modernmovieapp.network.network_model

import com.squareup.moshi.Json
import com.su.modernmovieapp.data.model.PlayingMovieUiModel
import com.su.modernmovieapp.localstorage.entity.PlayingMovieEntity
import kotlinx.serialization.Serializable

data class PlayingMoviewsResponse(

    @Json(name = "results")
    val movieResults: List<MovieResult>,
    @Json(name = "page")
    val page: Int = 0
)

data class MovieResult(
    @Json
    val popularity: Double,
    @Json
    val vote_count: Int,
    @Json
    val video: Boolean,
    @Json
    val poster_path: String?,
    @Json
    val id: Int,
    @Json
    val adult: Boolean,
    @Json
    val backdrop_path: String,
    @Json
    val original_language: String,
    @Json
    val original_title: String,
    @Json
    val genre_ids: List<Int>,
    @Json
    val title: String,
    @Json
    val vote_average: Double,
    @Json
    val overview: String,
    @Json
    val release_date: String
)

fun MovieResult.asUiModel() = PlayingMovieUiModel(id = id,title=title, posterPath = poster_path ?: "", voteAverage = vote_average,overview=overview, releaseDate = release_date, backdropPath=backdrop_path)

fun MovieResult.asEntity() = PlayingMovieEntity(id = id,title=title, posterPath = poster_path ?: "", voteAverage = vote_average,overview=overview, releaseDate = release_date, backdropPath = backdrop_path)