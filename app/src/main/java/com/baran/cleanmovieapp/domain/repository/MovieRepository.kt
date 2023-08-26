package com.baran.cleanmovieapp.domain.repository

import com.baran.cleanmovieapp.data.remote.dto.MovieDetailDto
import com.baran.cleanmovieapp.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search : String) : MoviesDto

    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto
}