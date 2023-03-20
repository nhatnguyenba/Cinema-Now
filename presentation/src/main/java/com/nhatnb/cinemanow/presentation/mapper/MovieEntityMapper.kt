package com.nhatnb.cinemanow.presentation.mapper

import com.nhatnb.cinemanow.data.local.entity.MovieDbEntity
import com.nhatnb.cinemanow.domain.model.Movie
import com.nhatnb.cinemanow.presentation.entities.MovieListItem

fun Movie.toMovieListItem(): MovieListItem {
    return MovieListItem(
        id = this.id,
        title = this.title,
        imageUrl = this.posterUrl,
        category = this.genre,
        rating = this.rating
    )
}

fun MovieDbEntity.toMovieListItem() = MovieListItem(
    id = this.id,
    title = this.title,
    imageUrl = this.posterUrl,
    category = this.genre,
    rating = this.rating
)