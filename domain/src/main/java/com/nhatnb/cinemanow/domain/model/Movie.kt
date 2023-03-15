package com.nhatnb.cinemanow.domain.model

import java.util.Date

data class Movie(
    val title: String,
    val genre: String,
    val releaseDate: Date,
    val director: String,
    val casts: List<String>,
    val rating: Float,
    val duration: Int,
    val description: String,
    val posterUrl: String,
    val trailerUrl: String,
    val language: String,
    val budget: Int
)