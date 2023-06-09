package com.nhatnb.cinemanow.domain.model

data class Movie(
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
    val budget: Int? = null
)