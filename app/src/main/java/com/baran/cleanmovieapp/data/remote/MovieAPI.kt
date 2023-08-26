package com.baran.cleanmovieapp.data.remote

import com.baran.cleanmovieapp.data.remote.dto.MovieDetailDto
import com.baran.cleanmovieapp.data.remote.dto.MoviesDto
import com.baran.cleanmovieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    //https://omdbapi.com/?apikey=f2e3d529&s=batman

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString :String,
        @Query("apikey") apiKey :String = API_KEY
    ) : MoviesDto

    //https://omdbapi.com/?apikey=f2e3d529&i=tt0372784

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey: String = API_KEY
    ) : MovieDetailDto
}