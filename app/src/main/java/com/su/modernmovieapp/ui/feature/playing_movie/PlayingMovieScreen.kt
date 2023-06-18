package com.su.modernmovieapp.ui.feature.playing_movie

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.su.modernmovieapp.R
import com.su.modernmovieapp.data.model.PlayingMovieUiModel
import com.su.modernmovieapp.ui.feature.playing_movie_detail.RatingBar
import com.su.modernmovieapp.ui.theme.Blue40
import com.su.modernmovieapp.ui.theme.Blue80


@Composable
fun PlayingMovieRoute(
    onNavigateToPlayingMovieDetail: (movieId: Int) -> Unit,
    modifier: Modifier,
    viewModel: PlayingMovieViewModel = hiltViewModel(),
) {
    val uiState: PlayingMovieUiState by viewModel.playingMovieUiState.collectAsState()
    PlayingMovieScreen(
        uiState,
        modifier = modifier,
        onClick = { onNavigateToPlayingMovieDetail(it) })

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayingMovieScreen(
    uiState: PlayingMovieUiState,
    modifier: Modifier,
    onClick: (movieId: Int) -> Unit
) {
    val searchQuery = remember { mutableStateOf("") }
    var showSettingsDialog by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            Surface(modifier = Modifier.fillMaxWidth()) {
                Column(
                    Modifier
                        .background(color = Blue40),
                ) {
                    MovieAppBar({})
                    SearchBar(onSearch = {})
                }
            }
        },
        content = { padding ->
            Box(modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Blue40,
                            Blue80
                        )
                    )
                )
                .padding(padding)){
            Column(
                modifier = modifier
                    .padding(12.dp)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2)
                ) {
                    items(uiState.playingMovies.size) {
                        val playingMovie = uiState.playingMovies[it]
                        MovieCardWithShape(playingMovie, modifier.clickable {
                            onClick(playingMovie.id)
                        })
                    }
                }
            }
        }})

}

@Composable
fun MovieAppBar(onSettingsClicked: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = onSettingsClicked) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.back),
                tint = Color.White,
            )
        }
    }
}

@Composable
private fun SearchBar(onSearch: (String) -> Unit) {
    Button(onClick = { onSearch }, shape = RoundedCornerShape(50), modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)
        .padding(horizontal = 16.dp)) {
    }
}

@Composable
fun MovieCardWithShape(uiModel: PlayingMovieUiModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(4.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(4.dp))
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://image.tmdb.org/t/p/w500${uiModel.posterPath}")
                    .build(),
                contentDescription = stringResource(R.string.description),
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
            RatingBar(rating = uiModel.voteAverage)
        }

        Text(
            text = "${uiModel.title}",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            modifier = modifier.padding(start = 6.dp, end = 4.dp)
        )

        Text(
            text = "${uiModel.releaseDate}",
            color = Color.White,
            fontSize = 10.sp,
            maxLines = 1,
            fontWeight = FontWeight.Normal,
            modifier = modifier.padding(start = 6.dp, top = 0.dp, end = 4.dp, bottom = 18.dp)
        )
    }
}
