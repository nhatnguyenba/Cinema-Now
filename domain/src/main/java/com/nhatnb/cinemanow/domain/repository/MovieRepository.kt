package com.nhatnb.cinemanow.domain.repository

import com.nhatnb.cinemanow.domain.model.Movie
import io.reactivex.rxjava3.core.Single
import com.nhatnb.cinemanow.domain.util.Result

interface MovieRepository {
    suspend fun getTrendingMovies(page: Int? = null, limit: Int? = null): Result<List<Movie>>

    suspend fun getPopularMovies(): Single<List<Movie>>
}