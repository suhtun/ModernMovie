package com.su.modernmovieapp.ui.feature.playing_movie_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.su.modernmovieapp.data.MovieRepository
import com.su.modernmovieapp.data.model.PlayingMovieUiModel
import com.su.modernmovieapp.navigation.Destinations
import com.su.modernmovieapp.util.Result
import com.su.modernmovieapp.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PlayingMovieDetailViewModel @Inject constructor(
    repository: MovieRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _playingMovieDetail = MutableStateFlow(PlayingMovieDetailUiState())
    val playingMovieUiState = _playingMovieDetail.asStateFlow()

    private val movieId: Int by lazy { checkNotNull(savedStateHandle[Destinations.MOVIE_ID]) }

    init {
        viewModelScope.launch {
            repository.findPlayingMovieDetail(movieId).asResult().collect { result ->
                _playingMovieDetail.update {
                    when (result) {
                        is Result.Loading -> {
                            PlayingMovieDetailUiState()
                        }

                        is Result.Success -> {
                            PlayingMovieDetailUiState(
                                isLoading = false,
                                playingMovie = result.data
                            )
                        }

                        is Result.Error -> {
                            PlayingMovieDetailUiState(isLoading = false)
                        }
                    }
                }
            }
        }
    }
}

data class PlayingMovieDetailUiState(
    val isLoading: Boolean = false,
    val playingMovie: PlayingMovieUiModel? = null
)