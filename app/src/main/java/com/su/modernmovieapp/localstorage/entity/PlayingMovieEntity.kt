package com.su.modernmovieapp.localstorage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.su.modernmovieapp.data.model.PlayingMovieUiModel

@Entity
data class PlayingMovieEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("poster_ath") val posterPath: String,
    @ColumnInfo("vote_average") val voteAverage: Double,
    @ColumnInfo("overview") val overview: String,
    @ColumnInfo("release_date") val releaseDate: String,
    @ColumnInfo("backdrop_path") val backdropPath: String
)


fun PlayingMovieEntity.asUiModel() = PlayingMovieUiModel(
    id = id,
    title = title,
    posterPath = posterPath,
    voteAverage = voteAverage,
    overview = overview,
    releaseDate = releaseDate,
    backdropPath = backdropPath
)