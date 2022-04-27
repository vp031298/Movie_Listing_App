package com.vaibhav.movielistingapp

import retrofit2.Call

class LorRepository(private val lorApi: LORApi.LorCalls) {

    fun getMovies() : Call<MovieResponse>{
        return lorApi.getMovies()
    }

    fun getMovieById(path : String) : Call<MovieResponse>{
        return lorApi.getMovieById(path)
    }
}