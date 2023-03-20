package com.nhatnb.cinemanow.data.repository

import com.nhatnb.cinemanow.data.MovieDataSource
import com.nhatnb.cinemanow.data.mapper.toMovie
import com.nhatnb.cinemanow.domain.model.Movie
import com.nhatnb.cinemanow.domain.repository.MovieRepository
import com.nhatnb.cinemanow.domain.util.Result
import com.nhatnb.cinemanow.domain.util.getResult
import io.reactivex.rxjava3.core.Single

class MovieRepositoryImpl(
    private val remote: MovieDataSource.Remote,
    private val local: MovieDataSource.Local
) : MovieRepository {

    override suspend fun getTrendingMovies(page: Int?, limit: Int?): Result<List<Movie>> {
        //get data from remote and then save to local db
        val result = remote.getTrendingMovies(page)
        return result.getResult(
            { successResponse ->
                local.saveMovies(successResponse.data)
                Result.Success(data = successResponse.data.map {
                    it.toMovie()
                })
            },
            { errorResponse ->
                Result.Error(errorResponse.error)
            }
        )
    }

    override suspend fun getPopularMovies(): Single<List<Movie>> {
        TODO("Not yet implemented")
    }

}