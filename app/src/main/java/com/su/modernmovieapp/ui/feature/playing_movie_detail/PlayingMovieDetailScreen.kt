package com.su.modernmovieapp.ui.feature.playing_movie_detail

import android.graphics.drawable.VectorDrawable
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.su.modernmovieapp.R
import com.su.modernmovieapp.ui.feature.playing_movie.MovieAppBar
import com.su.modernmovieapp.ui.theme.Orange40
import java.lang.Math.ceil
import java.lang.Math.floor

@Composable
fun PlayingMovieDetailRoute(
    onNavigateUp: () -> Unit,
    viewModel: PlayingMovieDetailViewModel = hiltViewModel()
) {
    val uiState: PlayingMovieDetailUiState by viewModel.playingMovieUiState.collectAsState()
    PlayingMovieDetailScreen(uiSate = uiState, onNavigateUp = { onNavigateUp })
    BackHandler() {
        onNavigateUp()
    }
}

@Composable
fun PlayingMovieDetailScreen(
    uiSate: PlayingMovieDetailUiState,
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit
) {
    uiSate.playingMovie?.let {
        Column(Modifier.background(color = Orange40)) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1F)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://image.tmdb.org/t/p/w500${it.backdropPath}")
                        .build(),
                    contentDescription = stringResource(R.string.description),
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxWidth()
                )
                MovieAppBar(onNavigateUp)
            }
            Box(
                modifier = Modifier
                    .weight(1F)
                    .padding(16.dp)
            ) {
                Column() {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                    ) {

                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://image.tmdb.org/t/p/w500${it.posterPath}")
                                .build(),
                            contentDescription = stringResource(R.string.description),
                            contentScale = ContentScale.Crop,
                            modifier = modifier
                                .fillMaxSize()
                                .weight(1F)
                                .clip(RoundedCornerShape(4.dp))
                        )

                        Column(
                            modifier = Modifier
                                .weight(2F)
                                .padding(16.dp)
                        ) {
                            RatingBar(rating = it.voteAverage)
                            Text(
                                text = "${it.title}",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                modifier = modifier.padding(top = 12.dp)
                            )

                            Text(
                                text = "${it.releaseDate}",
                                color = Color.White,
                                fontSize = 12.sp,
                                maxLines = 1,
                                fontWeight = FontWeight.Normal,
                                modifier = modifier.padding(top = 12.dp)
                            )
                        }
                    }
                    Divider(
                        color = Color.White,
                        thickness = 0.5.dp,
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.storyline),
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                    )

                    Text(
                        text = "${it.overview}",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    starsColor: Color = Color.Yellow,
) {
    val filledStars = floor(rating).toInt()
    val unfilledStars = (stars - ceil(rating)).toInt()
    val halfStar = !(rating.rem(1).equals(0.0))
    Row(modifier = modifier) {
        repeat(filledStars) {
            Icon(imageVector = Icons.Outlined.Star, contentDescription = null, tint = starsColor)
        }
        if (halfStar) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star_half),
                contentDescription = null,
                tint = starsColor
            )
        }
        repeat(unfilledStars) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star_outline),
                contentDescription = null,
                tint = starsColor
            )
        }
    }
}
