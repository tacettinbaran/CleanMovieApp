package com.baran.cleanmovieapp.presentation.movies

sealed class MoviesEvent {
    data class Search(val searchString :String) : MoviesEvent()

}