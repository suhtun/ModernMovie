package com.su.modernmovieapp

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.su.modernmovieapp.data.MovieRepository
import com.su.modernmovieapp.data.MovieRepositoryImpl
import com.su.modernmovieapp.database.TestPlayingMovieDao
import com.su.modernmovieapp.localstorage.dao.PlayingMovieDao
import com.su.modernmovieapp.navigation.Destinations
import com.su.modernmovieapp.network.fake.FakeNetworkDataSource
import com.su.modernmovieapp.ui.feature.playing_movie_detail.PlayingMovieDetailViewModel
import com.su.modernmovieapp.util.TestDispatcherRule
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PlayingMovieDetailViewModelTest {
    private lateinit var movieDao: PlayingMovieDao
    private lateinit var network: FakeNetworkDataSource
    private lateinit var repository: MovieRepository
    private lateinit var viewModel: PlayingMovieDetailViewModel

    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    @Before
    fun setUp() {
        movieDao = TestPlayingMovieDao()
        network = FakeNetworkDataSource(StandardTestDispatcher(), Json { ignoreUnknownKeys = true })
        repository = MovieRepositoryImpl(network, movieDao)
        viewModel = PlayingMovieDetailViewModel(
            repository = repository, savedStateHandle =
            SavedStateHandle(mapOf(Destinations.MOVIE_ID to 101))
        )
    }

    @Test
    fun `playing movies ui state when success matches movie repository`() = runTest {
        viewModel.playingMovieUiState.test {
            val item = awaitItem()
            val data = repository.findPlayingMovieDetail(101).first()
            Assert.assertEquals(item.playingMovie, data)
        }
    }
}