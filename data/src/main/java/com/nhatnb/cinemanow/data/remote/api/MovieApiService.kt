package com.nhatnb.cinemanow.data.remote.api

import com.nhatnb.cinemanow.data.remote.model.MovieResponseWrapper
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("trending/all/day")
    suspend fun getTrendingMovies(
        @Query("page") page: Int?
    ): MovieResponseWrapper

    @GET("discover/movie?language=en-US&sort_by=popularity.desc")
    fun getPopularMovies(
        @Query("page") page: Int
    ): Single<MovieResponseWrapper>
}