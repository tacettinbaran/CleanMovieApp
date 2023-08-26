package com.baran.cleanmovieapp.data.remote.dto

import com.baran.cleanmovieapp.domain.model.Movie

data class MoviesDto(

    val Response: String,
    val Search: List<Search>,
    val totalResults: String
){
    override fun toString(): String {
        return "MoviesDto(Response='$Response', Search=$Search, totalResults='$totalResults')"
    }
}

fun MoviesDto.toMovieList() :List<Movie> {
    return Search.map { search -> Movie(search.Poster,search.Title,search.Year,search.imdbID) }
}