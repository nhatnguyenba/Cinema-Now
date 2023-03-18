package com.nhatnb.cinemanow.domain.repository

import com.nhatnb.cinemanow.domain.model.Movie

interface MovieRepository {
    fun getTrendingMovies(): List<Movie>

    fun getPopularMovies(): List<Movie>
}