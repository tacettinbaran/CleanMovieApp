package com.baran.cleanmovieapp.domain.use_case.get_movies

import com.baran.cleanmovieapp.data.remote.dto.toMovieList
import com.baran.cleanmovieapp.domain.model.Movie
import com.baran.cleanmovieapp.domain.repository.MovieRepository
import com.baran.cleanmovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovies (search : String) : Flow<Resource<List<Movie>>> = flow {
        //Use case -> only one major public function, one feature, single responsibility
            try {
                emit(Resource.Loading())
                val movieList = repository.getMovies(search)
                if(movieList.Response.equals("True")) {
                    emit(Resource.Success(movieList.toMovieList()))
                } else {
                    emit(Resource.Error(message = "No movie found"))
                }
            } catch (e: HttpException) {
                emit(Resource.Error(message = e.localizedMessage ?: "Error HttpException!"))
            } catch (e: IOError) {
                emit(Resource.Error(message = "Could not reach internet Exc: " +e.localizedMessage))
            }


    }
}