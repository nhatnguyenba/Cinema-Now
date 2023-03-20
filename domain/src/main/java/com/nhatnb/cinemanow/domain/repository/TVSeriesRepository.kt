package com.nhatnb.cinemanow.domain.repository

import com.nhatnb.cinemanow.domain.model.TVSeries

interface TVSeriesRepository {
    suspend fun getPopularTVSeries(): List<TVSeries>
}