package com.su.modernmovieapp.network

import android.net.NetworkRequest
import com.su.modernmovieapp.network.network_model.MovieResult

interface NetworkDataSource {
    suspend fun getPlayingMovie(): List<MovieResult>
}