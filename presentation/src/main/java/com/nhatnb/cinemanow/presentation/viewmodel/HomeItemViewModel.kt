package com.nhatnb.cinemanow.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.nhatnb.cinemanow.data.local.dao.MovieDao
import com.nhatnb.cinemanow.data.remote.TrendingMovieRemoteMediator
import com.nhatnb.cinemanow.presentation.entities.MovieListItem
import com.nhatnb.cinemanow.presentation.mapper.toMovieListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeItemViewModel @Inject constructor(
    private val movieRemoteMediator: TrendingMovieRemoteMediator,
    private val movieDao: MovieDao
) : ViewModel() {

    companion object {
        private const val PAGE_SIZE = 20
    }

    @OptIn(ExperimentalPagingApi::class)
    val trendingMovies: LiveData<PagingData<MovieListItem>> =
        Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = movieRemoteMediator,
            pagingSourceFactory = { movieDao.getTrendingMovies() }
        ).flow.asLiveData()
            .map { pagingData ->
                pagingData.map { it.toMovieListItem() }
            }.cachedIn(viewModelScope)
}