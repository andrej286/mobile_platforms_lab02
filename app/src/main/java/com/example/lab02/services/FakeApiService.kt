package com.example.lab02.services

import com.example.lab02.models.Movie

class FakeApiService {

    private val movies: MutableList<Movie>  = mutableListOf(
        Movie(1, "Pirates of the Caribbean", "a pirates life", "Gore Verbinski", mutableListOf("Johnny Depp", "Orlando Bloom")),
        Movie(2, "The Dark Knight", "batman is born", "Christopher Nolan", mutableListOf("Christian Bale", "Michael Caine")),
    )

    fun getAllMovies(): MutableList<Movie> {
        return movies;
    }

    fun addMovie(movie: Movie) : MutableList<Movie> {
        movies.add(movie)
        return movies
    }

}