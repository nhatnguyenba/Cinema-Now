package com.nhatnb.cinemanow.data.remote.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("adult")
    var adult: Boolean? = null,
    @SerializedName("backdrop_path")
    var backdropPath: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("original_language")
    var originalLanguage: String? = null,
    @SerializedName("original_title")
    var originalTitle: String? = null,
    @SerializedName("overview")
    var overview: String? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null,
    @SerializedName("media_type")
    var mediaType: String? = null,
    @SerializedName("genre_ids")
    var genreIds: ArrayList<Int> = arrayListOf(),
    @SerializedName("popularity")
    var popularity: Double? = null,
    @SerializedName("release_date")
    var releaseDate: String? = null,
    @SerializedName("video")
    var video: Boolean? = null,
    @SerializedName("vote_average")
    var voteAverage: Double? = null,
    @SerializedName("vote_count")
    var voteCount: Int? = null
)

data class MovieResponseWrapper(
    var page: Int? = null,
    @SerializedName("results")
    var movies: List<MovieResponse>? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("total_results")
    var totalResults: Int? = null
)