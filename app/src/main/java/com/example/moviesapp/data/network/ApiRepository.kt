package com.example.moviesapp.data.network

import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiRepository: ApiService) {

    suspend fun getAllMovies() = apiRepository.getAllMovies()

}