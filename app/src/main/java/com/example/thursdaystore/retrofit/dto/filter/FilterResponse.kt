package com.example.thursdaystore.retrofit.dto.filter

import com.squareup.moshi.Json

data class FilterResponse(
    @Json(name = "propertyId")
    private val propertyId: Long,
    @Json(name = "propertyName")
    private val propertyName: String,
    @Json(name = "parameters")
    private val filterParameters: List<FilterParameter>
)