package com.nhatnb.cinemanow.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nhatnb.cinemanow.data.local.entity.MovieDbEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getTrendingMovies(): PagingSource<Int, MovieDbEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<MovieDbEntity>)

    @Query("DELETE FROM movies")
    suspend fun deleteAllMovies()
    
    @Query("SELECT * FROM movies ORDER BY page DESC LIMIT 1")
    suspend fun getLastTrendingMovie(): MovieDbEntity
}