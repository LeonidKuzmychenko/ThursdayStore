package com.example.thursdaystore.retrofit.dto.filter

import com.squareup.moshi.Json

data class FilterParameter(
    @Json(name = "parameterId")
    private val parameterId: Long,
    @Json(name = "parameterName")
    private val parameterName: String
)