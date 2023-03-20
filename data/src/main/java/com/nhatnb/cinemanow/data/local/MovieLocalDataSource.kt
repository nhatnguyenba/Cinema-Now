package com.nhatnb.cinemanow.data.local

import androidx.paging.PagingSource
import com.nhatnb.cinemanow.data.MovieDataSource
import com.nhatnb.cinemanow.data.MovieEntity
import com.nhatnb.cinemanow.data.local.dao.MovieDao
import com.nhatnb.cinemanow.data.local.entity.MovieDbEntity
import com.nhatnb.cinemanow.data.mapper.toMovieDbEntity
import com.nhatnb.cinemanow.domain.model.Movie
import com.nhatnb.cinemanow.domain.util.Result

class MovieLocalDataSource(private val movieDao: MovieDao): MovieDataSource.Local {
    override fun getTrendingMovies(): PagingSource<Int, MovieDbEntity> {
        return movieDao.getTrendingMovies()
    }

    override suspend fun getPopularMovies(page: Int?, limit: Int?): Result<List<Movie>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovie(movieId: Int): Result<Movie> {
        TODO("Not yet implemented")
    }

    override suspend fun saveMovies(movieEntities: List<MovieEntity>) {
        movieDao.saveMovies(movieEntities.map {
            it.toMovieDbEntity()
        })
    }

    override suspend fun deleteAllTrendingMovies() {
        movieDao.deleteAllMovies()
    }
}