package com.nhatnb.cinemanow.domain.usecase

import com.nhatnb.cinemanow.domain.model.TVSeries
import com.nhatnb.cinemanow.domain.repository.TVSeriesRepository

class GetPopularTVSeries(
    private val tvSeriesRepository: TVSeriesRepository
) {
    suspend operator fun invoke(): List<TVSeries> = tvSeriesRepository.getPopularTVSeries()
}