package com.nhatnb.cinemanow.data.mapper

import com.nhatnb.cinemanow.data.MovieEntity
import com.nhatnb.cinemanow.data.local.entity.MovieDbEntity
import com.nhatnb.cinemanow.data.remote.model.MovieResponse
import com.nhatnb.cinemanow.data.remote.model.MovieResponseWrapper
import com.nhatnb.cinemanow.domain.model.Movie

fun MovieDbEntity.toMovieEntity() = MovieEntity(
    id = id,
    title = title,
    genre = genre,
    releaseDate = releaseDate,
    director = director,
    casts = casts,
    rating = rating,
    duration = duration,
    description = description,
    posterUrl = posterUrl,
    trailerUrl = trailerUrl,
    language = language,
    budget = budget,
    page = page
)

fun MovieEntity.toMovie() = Movie(
    id = id,
    title = title,
    genre = genre,
    releaseDate = releaseDate,
    director = director,
    casts = casts,
    rating = rating,
    duration = duration,
    description = description,
    posterUrl = posterUrl,
    trailerUrl = trailerUrl,
    language = language,
    budget = budget
)

fun MovieEntity.toMovieDbEntity() = MovieDbEntity(
    id = id,
    title = title,
    genre = genre,
    releaseDate = releaseDate,
    director = director,
    casts = casts,
    rating = rating,
    duration = duration,
    description = description,
    posterUrl = posterUrl,
    trailerUrl = trailerUrl,
    language = language,
    budget = budget,
    page = page
)

fun MovieResponse.toMovieEntity() = MovieEntity(
    id = id,
    title = title,
    genre = null,
    releaseDate = releaseDate,
    rating = voteAverage?.toFloat(),
    description = overview,
    posterUrl = posterPath,
    language = originalLanguage
)

fun MovieResponseWrapper.toMovieEntityList(): List<MovieEntity> {
    val movieEntities = mutableListOf<MovieEntity>()
    movies?.forEach { movieResponse ->
        movieEntities.add(
            MovieEntity(
                id = movieResponse.id,
                title =  if(movieResponse.title.isNullOrEmpty()) movieResponse.name else movieResponse.title,
                genre = null,
                releaseDate = movieResponse.releaseDate,
                rating = movieResponse.voteAverage?.toFloat(),
                description = movieResponse.overview,
                posterUrl = movieResponse.posterPath,
                language = movieResponse.originalLanguage,
                page = this.page
            )
        )
    }
    return movieEntities
}