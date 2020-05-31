package com.example.thursdaystore.retrofit.dto.filter.request

import com.squareup.moshi.Json
import java.io.Serializable

class Prices(
    @Json(name = "min")
    var min: Long,
    @Json(name = "max")
    var max: Long
): Serializable