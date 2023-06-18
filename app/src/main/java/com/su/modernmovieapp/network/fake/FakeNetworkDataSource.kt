package com.su.modernmovieapp.network.fake

import com.su.modernmovieapp.network.NetworkDataSource
import com.su.modernmovieapp.network.network_model.MovieResult
import com.su.modernmovieapp.util.Dispatcher
import com.su.modernmovieapp.util.MovieDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class FakeNetworkDataSource @Inject constructor(
    @Dispatcher(MovieDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val networkJson: Json
) : NetworkDataSource {


    override suspend fun getPlayingMovie(): List<MovieResult> = withContext(ioDispatcher) {
        networkJson.decodeFromString(FakeDataSource.playingMovieData)
    }
}