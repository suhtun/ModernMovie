package com.su.modernmovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.su.modernmovieapp.navigation.Destinations.HOME_ROUTE
import com.su.modernmovieapp.navigation.Destinations.MOVIE_DETAIL_ROUTE
import com.su.modernmovieapp.navigation.Destinations.MOVIE_ID
import com.su.modernmovieapp.ui.feature.playing_movie.PlayingMovieRoute
import com.su.modernmovieapp.ui.feature.playing_movie_detail.PlayingMovieDetailRoute

object Destinations {
    const val HOME_ROUTE = "home"
    const val MOVIE_DETAIL_ROUTE = "moviedetail/{movieid}"

    const val MOVIE_ID = "movieid"
}


@Composable
fun MovieAppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        modifier = modifier
    ) {
        composable(HOME_ROUTE) {
            PlayingMovieRoute(
                onNavigateToPlayingMovieDetail = { navController.navigate(route = "moviedetail/${it}") },
                modifier = modifier
            )
        }

        composable(MOVIE_DETAIL_ROUTE,arguments = listOf(
            navArgument(MOVIE_ID) {
                type = NavType.IntType
            })){
            PlayingMovieDetailRoute(onNavigateUp = { navController.navigateUp()})
        }
    }
}
