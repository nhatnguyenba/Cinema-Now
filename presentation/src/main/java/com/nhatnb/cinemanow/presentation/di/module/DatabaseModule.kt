package com.nhatnb.cinemanow.presentation.di.module

import android.content.Context
import com.nhatnb.cinemanow.data.local.dao.MovieDao
import com.nhatnb.cinemanow.data.local.db.CinemaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): CinemaDatabase {
        return CinemaDatabase.getInstance(appContext)
    }

    @Provides
    fun provideMovieDao(database: CinemaDatabase): MovieDao {
        return database.movieDao()
    }
}