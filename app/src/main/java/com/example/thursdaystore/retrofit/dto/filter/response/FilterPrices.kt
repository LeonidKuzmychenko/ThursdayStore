package com.example.thursdaystore.retrofit.dto.filter.response

import com.squareup.moshi.Json

class FilterPrices(
    @Json(name = "max")
    val max: String
)