package com.example.thursdaystore.retrofit.dto.filter.request

import com.squareup.moshi.Json
import java.io.Serializable

data class FilterPricesRequest(
    @Json(name = "min")
    var min: Long,
    @Json(name = "max")
    var max: Long
): Serializable