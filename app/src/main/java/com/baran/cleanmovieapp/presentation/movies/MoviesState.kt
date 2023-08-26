package com.baran.cleanmovieapp.presentation.movies

import com.baran.cleanmovieapp.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "deadpool"
)