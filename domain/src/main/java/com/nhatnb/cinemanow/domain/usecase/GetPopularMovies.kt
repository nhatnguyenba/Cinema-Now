package com.nhatnb.cinemanow.domain.usecase

import com.nhatnb.cinemanow.domain.model.Movie
import com.nhatnb.cinemanow.domain.repository.MovieRepository
import io.reactivex.rxjava3.core.Single

class GetPopularMovies(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(): Single<List<Movie>> = movieRepository.getPopularMovies()
}