package com.su.modernmovieapp.network.retrofit

import com.su.modernmovieapp.network.network_model.PlayingMoviewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("now_playing?page=1")
    suspend fun getPlayingMovie(@Query("api_key") apiKey: String = API_KEY): PlayingMoviewsResponse

//    @GET("now_playing")
//    fun getPlayingMovie(@Query("page") page: Int): Call<PlayingMoviewsResponse>
//
//    @GET("{movie_id}/similar?page=1")
//    fun getSimilarMovies(@Path("movie_id") id: Int): LiveData<ApiResponse<PlayingMoviewsResponse>>
//
//    @GET("{movie_id}/similar")
//    fun getSimilarMovies(@Path("movie_id") id: Int, @Query("page") page: Int): Call<PlayingMoviewsResponse>

    companion object{
        const val API_KEY = "db881ce3bedabbd0b8dd806b1e9901b3"
        const val NETWORK_API = "https://api.themoviedb.org/3/movie/"
    }
}