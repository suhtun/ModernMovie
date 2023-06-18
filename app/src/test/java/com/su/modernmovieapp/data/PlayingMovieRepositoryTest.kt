package com.su.modernmovieapp.data

import com.su.modernmovieapp.database.TestPlayingMovieDao
import com.su.modernmovieapp.localstorage.dao.PlayingMovieDao
import com.su.modernmovieapp.localstorage.entity.PlayingMovieEntity
import com.su.modernmovieapp.localstorage.entity.asUiModel
import com.su.modernmovieapp.network.fake.FakeNetworkDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PlayingMovieRepositoryTest {

    private lateinit var movieDao: PlayingMovieDao
    private lateinit var network: FakeNetworkDataSource
    private lateinit var subject: MovieRepository

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        movieDao = TestPlayingMovieDao()
        network = FakeNetworkDataSource(testDispatcher, Json { ignoreUnknownKeys = true })
        subject = MovieRepositoryImpl(network, dao = movieDao)
    }

    @Test
    fun `offline first movie repository playing movie stream is backed by movie dao`() = runTest {
        Assert.assertEquals(
            movieDao.getAllPlayingMovies().map(PlayingMovieEntity::asUiModel),
            subject.getPlayingMovie().first()
        )
    }

    @Test
    fun `find playing movie detail by movie id`() = runTest {
        val movieId = 101
        Assert.assertEquals(
            movieDao.searchPlayingMovie(movieId).let(PlayingMovieEntity::asUiModel),
            subject.findPlayingMovieDetail(movieId).first()
        )
    }
}