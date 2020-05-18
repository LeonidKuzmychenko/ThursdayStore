package com.example.thursdaystore.retrofit.dto.filter

import com.squareup.moshi.Json

data class FilterResponse(
    @Json(name = "propertyId")
    val propertyId: Long,
    @Json(name = "propertyName")
    val propertyName: String,
    @Json(name = "parameters")
    val filterParameters: List<FilterParameter>
)