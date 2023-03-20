package com.nhatnb.cinemanow.data

import androidx.paging.PagingSource
import com.nhatnb.cinemanow.data.local.entity.MovieDbEntity
import com.nhatnb.cinemanow.domain.model.Movie
import com.nhatnb.cinemanow.domain.util.Result

interface MovieDataSource {

    interface Remote {
        suspend fun getTrendingMovies(page: Int? = null, limit: Int? = null): Result<List<MovieEntity>>
        suspend fun getPopularMovies(page: Int? = null, limit: Int? = null): Result<List<MovieEntity>>
        suspend fun getMovie(movieId: Int): Result<Movie>
    }

    interface Local {
        fun getTrendingMovies(): PagingSource<Int, MovieDbEntity>
        suspend fun getPopularMovies(page: Int? = null, limit: Int? = null): Result<List<Movie>>
        suspend fun getMovie(movieId: Int): Result<Movie>
        suspend fun saveMovies(movieEntities: List<MovieEntity>)
        suspend fun deleteAllTrendingMovies()
        suspend fun getLastTrendingMovie(): MovieEntity
    }
}