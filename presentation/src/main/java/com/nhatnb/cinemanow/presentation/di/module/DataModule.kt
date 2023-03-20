package com.nhatnb.cinemanow.presentation.di.module

import com.nhatnb.cinemanow.data.MovieDataSource
import com.nhatnb.cinemanow.data.local.MovieLocalDataSource
import com.nhatnb.cinemanow.data.local.dao.MovieDao
import com.nhatnb.cinemanow.data.remote.MovieRemoteDataSource
import com.nhatnb.cinemanow.data.remote.TrendingMovieRemoteMediator
import com.nhatnb.cinemanow.data.remote.api.MovieApiService
import com.nhatnb.cinemanow.data.repository.MovieRepositoryImpl
import com.nhatnb.cinemanow.domain.repository.MovieRepository
import com.nhatnb.cinemanow.domain.usecase.GetTrendingMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideMovieRepository(
        remote: MovieDataSource.Remote,
        local: MovieDataSource.Local
    ): MovieRepository {
        return MovieRepositoryImpl(
            remote = remote,
            local = local
        )
    }

    @Provides
    fun provideGetTrendingMoviesUseCase(movieRepository: MovieRepository): GetTrendingMovies {
        return GetTrendingMovies(movieRepository)
    }

    @Provides
    fun provideTrendingMovieRemoteMediator(
        movieRepository: MovieRepository,
        local: MovieDataSource.Local
    ): TrendingMovieRemoteMediator{
        return TrendingMovieRemoteMediator(movieRepository, local)
    }

    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieDataSource.Local{
        return MovieLocalDataSource(movieDao)
    }

    @Provides
    fun provideMovieRemoteDataSource(movieApiService: MovieApiService): MovieDataSource.Remote{
        return MovieRemoteDataSource(movieApiService)
    }
}