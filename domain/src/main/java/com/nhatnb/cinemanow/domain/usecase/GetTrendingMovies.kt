package com.nhatnb.cinemanow.domain.usecase

import com.nhatnb.cinemanow.domain.model.Movie
import com.nhatnb.cinemanow.domain.repository.MovieRepository
import com.nhatnb.cinemanow.domain.util.Result

class GetTrendingMovies(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(): Result<List<Movie>> = movieRepository.getTrendingMovies()
}