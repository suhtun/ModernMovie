package com.su.modernmovieapp.ui.feature.playing_movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.su.modernmovieapp.data.MovieRepository
import com.su.modernmovieapp.data.model.PlayingMovieUiModel
import com.su.modernmovieapp.util.Result
import com.su.modernmovieapp.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayingMovieViewModel @Inject constructor(movieRepository: MovieRepository) : ViewModel() {
    private val _playingMovie = MutableStateFlow(PlayingMovieUiState())
    val playingMovieUiState = _playingMovie.asStateFlow()

    init {
        viewModelScope.launch {
            movieRepository.getPlayingMovie().asResult().collect { result ->
                _playingMovie.update {
                    when (result) {
                        is Result.Loading -> {
                            PlayingMovieUiState()
                        }

                        is Result.Success -> {
                            PlayingMovieUiState(isLoading = false, playingMovies = it.playingMovies + result.data)
                        }

                        is Result.Error -> {
                            PlayingMovieUiState(isLoading = false)
                        }
                    }
                }
            }
        }
    }
}

data class PlayingMovieUiState(
    val isLoading: Boolean = false,
    val playingMovies: List<PlayingMovieUiModel> = emptyList()
)