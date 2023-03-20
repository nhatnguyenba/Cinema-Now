package com.nhatnb.cinemanow.data

data class MovieEntity(
    val id: Int? = null,
    val title: String? = null,
    val genre: String? = null,
    val releaseDate: String? = null,
    val director: String? = null,
    val casts: String? = null,
    val rating: Float? = null,
    val duration: Int? = null,
    val description: String? = null,
    val posterUrl: String? = null,
    val trailerUrl: String? = null,
    val language: String? = null,
    val budget: Int? = null,
    val page: Int? = null
)