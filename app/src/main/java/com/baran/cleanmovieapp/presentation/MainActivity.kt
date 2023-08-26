package com.baran.cleanmovieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.baran.cleanmovieapp.presentation.movie_detail.views.MovieDetailScreen
import com.baran.cleanmovieapp.presentation.movies.views.MovieScreen
import com.baran.cleanmovieapp.presentation.ui.CleanMovieAppTheme
import com.baran.cleanmovieapp.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanMovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.MovieScreen.route
                    ) {
                        composable(route = Screen.MovieScreen.route) {
                            MovieScreen(navController = navController)
                        }
                        composable(route = Screen.MovieDetailScreen.route+"/{${IMDB_ID}}") {
                            MovieDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
