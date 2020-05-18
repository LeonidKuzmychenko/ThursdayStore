package com.example.thursdaystore.retrofit.dto.filter

import com.squareup.moshi.Json

data class FilterParameter(
    @Json(name = "parameterId")
    val parameterId: Long,
    @Json(name = "parameterName")
    val parameterName: String
)