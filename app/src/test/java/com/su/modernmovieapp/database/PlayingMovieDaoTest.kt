package com.su.modernmovieapp.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.su.modernmovieapp.localstorage.MovieDatabase
import com.su.modernmovieapp.localstorage.dao.PlayingMovieDao
import com.su.modernmovieapp.network.network_model.MovieResult
import com.su.modernmovieapp.network.network_model.asEntity
import com.su.modernmovieapp.util.MockUtil
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PlayingMovieDaoTest{
    private lateinit var playingMovieDao: PlayingMovieDao
    lateinit var database: MovieDatabase

    @Before
    fun initDatabase(){
        database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), MovieDatabase::class.java)
            .allowMainThreadQueries().build()
        playingMovieDao = database.playingMovieDao()
    }

    @After
    fun closeDatabase(){
        database.close()
    }

    @Test
    fun insertAndLoadPlayingMovie()= runBlocking{
        val mockCompanyListing = MockUtil.createMovieResult(3,"aa").map(MovieResult::asEntity)
        playingMovieDao.insertPlayingMovies(mockCompanyListing)

        val loadFromDatabase = playingMovieDao.searchPlayingMovie(mockCompanyListing[0].id)
        MatcherAssert.assertThat(loadFromDatabase.toString(), `is`(mockCompanyListing[0].toString()))
    }
}