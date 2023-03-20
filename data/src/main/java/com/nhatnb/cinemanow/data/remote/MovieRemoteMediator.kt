package com.nhatnb.cinemanow.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.nhatnb.cinemanow.data.MovieDataSource
import com.nhatnb.cinemanow.data.local.entity.MovieDbEntity
import com.nhatnb.cinemanow.domain.repository.MovieRepository
import com.nhatnb.cinemanow.domain.util.getResult

@OptIn(ExperimentalPagingApi::class)
class TrendingMovieRemoteMediator(
    private val movieRepository: MovieRepository,
    private val local: MovieDataSource.Local
) : RemoteMediator<Int, MovieDbEntity>() {

    companion object {
        private const val MOVIE_STARTING_PAGE_INDEX = 1
    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, MovieDbEntity>): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> { // gets called when it's the first time we're loading data, or when PagingDataAdapter.refresh() is called
                println("Vao LoadType.REFRESH ")
                MOVIE_STARTING_PAGE_INDEX
            }
            LoadType.PREPEND -> { // The beginning of the currently loaded data set
                println("Vao LoadType.PREPEND ")
                return MediatorResult.Success(endOfPaginationReached = true)
            }
            LoadType.APPEND -> { //end of the page
                println("Vao LoadType.APPEND")
                val lastPage =
                    local.getLastTrendingMovie().page ?: return MediatorResult.Success(endOfPaginationReached = true)
                lastPage + 1
            }
        }

        if (loadType == LoadType.REFRESH) {
            local.deleteAllTrendingMovies()
        }

        println("page: $page")

        movieRepository.getTrendingMovies(page).getResult(
            { successResult ->
                val movies = successResult.data
                val endOfPaginationReached = movies.isEmpty()
                return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
            },
            { errorResult ->
                return MediatorResult.Error(errorResult.error)
            }
        )

    }
}