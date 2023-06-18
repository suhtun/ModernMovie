package com.su.modernmovieapp.util

import com.su.modernmovieapp.data.model.PlayingMovieUiModel
import com.su.modernmovieapp.localstorage.entity.PlayingMovieEntity
import com.su.modernmovieapp.network.network_model.MovieResult
import java.util.concurrent.ThreadLocalRandom

object MockUtil {
    fun createMovieResult(count: Int, title: String): List<MovieResult> {
        return (0 until count).map {
            createMovieResponse(title)
        }
    }

    fun movieResultToMovie(list: List<MovieResult>): List<PlayingMovieUiModel> {
        return list.map {
            PlayingMovieUiModel(
                it.id,
                it.title,
                it.poster_path ?: "",
                it.vote_average,
                it.overview,
                it.release_date,
                backdropPath = it.backdrop_path
            )
        }
    }

    fun createPlayingMovieEntity(): PlayingMovieEntity {
        return PlayingMovieEntity(
            101,
            posterPath = "/gajva2L0rPYkEWjzgFlBXCAVBE5.jpg",
            title = "aa",
            voteAverage = 4.5,
            overview = "Thirty years after the events of the first film, a new blade runner, LAPD Officer K, unearths a long-buried secret that has the potential to plunge what's left of society into chaos. K's discovery leads him on a quest to find Rick Deckard, a former LAPD blade runner who has been missing for 30 years.",
            releaseDate = "2019-10-04",
            backdropPath = "/gajva2L0rPYkEWjzgFlBXCAVBE5.jpg"
        )
    }

    fun createMovie(title: String) = PlayingMovieUiModel(
        randomInt(), title, randomUuid(), randomDouble(), "this is cartoon movie",
        randomUuid(), randomUuid()
    )


    fun createMovieResponse(title: String) = MovieResult(
        43.929,
        7271,
        false,
        "/gajva2L0rPYkEWjzgFlBXCAVBE5.jpg",
        randomInt(),
        false,
        "/8QXGNP0Vb4nsYKub59XpAhiUSQN.jpg",
        "en",
        "Blade Runner 2049",
        arrayListOf<Int>(),
        title,
        7.4,
        "Thirty years after the events of the first film, a new blade runner, LAPD Officer K, unearths a long-buried secret that has the potential to plunge what's left of society into chaos. K's discovery leads him on a quest to find Rick Deckard, a former LAPD blade runner who has been missing for 30 years.",
        "/gajva2L0rPYkEWjzgFlBXCAVBE5.jpg"
    )

    fun randomUuid(): String {
        return java.util.UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }

    fun randomDouble(): Double {
        return ThreadLocalRandom.current().nextDouble(0.0, 1000.0 + 1)
    }
}