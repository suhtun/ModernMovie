package com.su.modernmovieapp.network.retrofit

import com.su.modernmovieapp.network.NetworkDataSource
import com.su.modernmovieapp.network.network_model.MovieResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitNetworkDataSource @Inject constructor(val movieApi: MovieApi) : NetworkDataSource {
    override suspend fun getPlayingMovie(): List<MovieResult> {
        return movieApi.getPlayingMovie().movieResults
    }
}