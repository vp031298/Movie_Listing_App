package com.vaibhav.movielistingapp

import androidx.lifecycle.ViewModel
import retrofit2.Call

class LorViewModel(private val lorRepository: LorRepository) : ViewModel() {

    fun getMovies(): Call<MovieResponse> {
        return lorRepository.getMovies()
    }

    fun getMovieById(path : String) : Call<MovieResponse> {
        return lorRepository.getMovieById(path)
    }
}