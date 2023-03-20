package com.nhatnb.cinemanow.data.remote

import com.nhatnb.cinemanow.data.MovieDataSource
import com.nhatnb.cinemanow.data.MovieEntity
import com.nhatnb.cinemanow.data.mapper.toMovieEntityList
import com.nhatnb.cinemanow.data.remote.api.MovieApiService
import com.nhatnb.cinemanow.domain.model.Movie
import com.nhatnb.cinemanow.domain.util.Result

class MovieRemoteDataSource(
    private val movieApiService: MovieApiService
) : MovieDataSource.Remote {
    override suspend fun getTrendingMovies(page: Int?, limit: Int?): Result<List<MovieEntity>> = try {
        val result = movieApiService.getTrendingMovies(page)
        Result.Success(result.toMovieEntityList())
    } catch (e: Exception) {
        Result.Error(e)
    }


    override suspend fun getPopularMovies(page: Int?, limit: Int?): Result<List<MovieEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovie(movieId: Int): Result<Movie> {
        TODO("Not yet implemented")
    }
}