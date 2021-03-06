package com.theapache64.retrosheet.sample.raven

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/**
 * Created by theapache64 : Sep 09 Wed,2020 @ 22:09
 */
@JsonClass(generateAdapter = true)
data class Quote(
    @Json(name = "date")
    val date: String,
    @Json(name = "quote")
    val quote: String
)