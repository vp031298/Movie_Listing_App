package com.vaibhav.movielistingapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    val repository: LorRepository = LorRepository(LORApi.getService())
    lateinit var viewModel: LorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, LorViewModelFactory(repository)).get(LorViewModel::class.java)
        getMovies()
    }

    fun getMovies() {
        var result = viewModel.getMovies()
        result.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                var movieResponse: MovieResponse? = response.body()
                Toast.makeText(this@MainActivity, "Response Successful", Toast.LENGTH_SHORT).show()

                var recyclerView: RecyclerView? = findViewById(R.id.recyclerView)
                recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView!!.adapter = RecyclerViewAdapter(movieResponse!!)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Response failure", Toast.LENGTH_SHORT).show()

            }

        })
    }

    fun getMovieById(){

    }
}