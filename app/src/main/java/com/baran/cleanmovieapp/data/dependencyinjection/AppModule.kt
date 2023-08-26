package com.baran.cleanmovieapp.data.dependencyinjection

import com.baran.cleanmovieapp.data.remote.MovieAPI
import com.baran.cleanmovieapp.data.repository.MovieRepositoryImpl
import com.baran.cleanmovieapp.domain.repository.MovieRepository
import com.baran.cleanmovieapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApp() : MovieAPI {
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieAPI) : MovieRepository {
        return MovieRepositoryImpl(api = api)
    }

}