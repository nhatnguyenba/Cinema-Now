package com.nhatnb.cinemanow.domain.usecase

import com.nhatnb.cinemanow.domain.model.Movie
import com.nhatnb.cinemanow.domain.repository.MovieRepository

class GetTrendingMovies(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): List<Movie> = movieRepository.getTrendingMovies()
}