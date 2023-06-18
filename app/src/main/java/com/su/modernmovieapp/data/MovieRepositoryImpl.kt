package com.su.modernmovieapp.data

import com.su.modernmovieapp.data.model.PlayingMovieUiModel
import com.su.modernmovieapp.localstorage.dao.PlayingMovieDao
import com.su.modernmovieapp.localstorage.entity.PlayingMovieEntity
import com.su.modernmovieapp.localstorage.entity.asUiModel
import com.su.modernmovieapp.network.NetworkDataSource
import com.su.modernmovieapp.network.retrofit.MovieApi
import com.su.modernmovieapp.network.network_model.MovieResult
import com.su.modernmovieapp.network.network_model.asEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

class MovieRepositoryImpl @Inject constructor(
    val network: NetworkDataSource,
    val dao: PlayingMovieDao
) : MovieRepository {
    override fun getPlayingMovie(): Flow<List<PlayingMovieUiModel>> = flow {
        val localdata = dao.getAllPlayingMovies()
        if (localdata.isNotEmpty()) emit(localdata.map(PlayingMovieEntity::asUiModel))
        else {
            val response = network.getPlayingMovie().map(MovieResult::asEntity)
            dao.insertPlayingMovies(response)
            val recentLocaldata = dao.getAllPlayingMovies()
            emit(recentLocaldata.map(PlayingMovieEntity::asUiModel))
        }
    }.flowOn(Dispatchers.IO)

    override fun findPlayingMovieDetail(movieId: Int): Flow<PlayingMovieUiModel> =
        flow {
            val data = dao.searchPlayingMovie(movieId)
            emit(data.let(PlayingMovieEntity::asUiModel))
        }.flowOn(Dispatchers.IO)
}