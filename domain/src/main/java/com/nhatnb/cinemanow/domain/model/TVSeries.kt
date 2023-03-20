package com.nhatnb.cinemanow.domain.model

data class TVSeries(
    val title: String,
    val season: Int,
    val numberOfEpisodes: Int,
    val genre: String,
    val releaseYear: Int,
    val rating: Float
)
