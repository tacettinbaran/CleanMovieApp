package com.baran.cleanmovieapp.presentation.movie_detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.baran.cleanmovieapp.presentation.movie_detail.MovieDetailViewModel

@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
) {
    val state = movieDetailViewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black), contentAlignment = Alignment.Center
    ) {
        state?.movie?.let {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberImagePainter(data = it.Poster),
                    contentDescription = it.Title,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(300.dp, 300.dp)
                        .clip(RectangleShape)
                        .align(CenterHorizontally)
                )

                Text(
                    text = "Title : ${it.Title}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(12.dp),
                    color = Color.White
                )

                Text(
                    text = "Year : ${it.Year}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(12.dp),
                    color = Color.White
                )

                Text(
                    text = "Actors : ${it.Actors}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(12.dp),
                    color = Color.White
                )

                Text(
                    text = "Country : ${it.Country}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(12.dp),
                    color = Color.White
                )

                Text(
                    text = "Director : ${it.Director}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(12.dp),
                    color = Color.White
                )

                Text(
                    text = "IMDB Rating : ${it.imdbRating}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(12.dp),
                    color = Color.White
                )

            }
        }

        if (state.error.isNotBlank())
            Text(text = state.error,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .align(Center)
            )

        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Center))
        }

    }

}