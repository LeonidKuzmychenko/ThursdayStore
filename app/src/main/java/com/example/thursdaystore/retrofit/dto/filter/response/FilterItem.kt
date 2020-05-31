package com.example.thursdaystore.retrofit.dto.filter.response

import com.squareup.moshi.Json

data class FilterItem(
    @Json(name = "properties")
    val properties: List<FilterProperties>,
    @Json(name = "prices")
    val filterPrices: FilterPrices
)