package com.example.thursdaystore.retrofit.dto.filter.request

import com.squareup.moshi.Json
import java.io.Serializable

data class Property(
    @Json(name = "propertyId")
    val propertyId: Long,

    @Json(name = "parameters")
    val parameters: MutableList<Long> = mutableListOf()
) : Serializable