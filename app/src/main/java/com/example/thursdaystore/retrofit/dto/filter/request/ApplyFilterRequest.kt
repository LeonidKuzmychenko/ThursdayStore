package com.example.thursdaystore.retrofit.dto.filter.request

import com.squareup.moshi.Json
import java.io.Serializable

data class ApplyFilterRequest(
    @Json(name = "catId")
    val catId: Long,
    @Json(name = "lang")
    val lang: String,
    @Json(name = "filters")
    val filters: List<Property> = listOf()
) : Serializable