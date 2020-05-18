package com.example.thursdaystore.retrofit.dto.product

import com.squareup.moshi.Json

data class ProductResponse(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String?,
    @Json(name = "description")
    val description: String,
    @Json(name = "images")
    val images: List<String>,
    @Json(name = "price")
    val price: Long
)