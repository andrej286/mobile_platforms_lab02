package com.example.lab02.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab02.models.Movie

class SelectedMovieViewModel: ViewModel() {

    private val mutableMovie = MutableLiveData<Movie>()

    val selectedMovie: LiveData<Movie> get() = mutableMovie

    fun selectMovie(selectedMovie: Movie){
        mutableMovie.value = selectedMovie
    }
}