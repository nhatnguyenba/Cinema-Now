package com.nhatnb.cinemanow.domain.repository

import com.nhatnb.cinemanow.domain.model.TVSeries

interface TVSeriesRepository {
    fun getPopularTVSeries(): List<TVSeries>
}