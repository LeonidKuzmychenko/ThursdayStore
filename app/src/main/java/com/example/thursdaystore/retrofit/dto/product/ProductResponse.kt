package com.example.thursdaystore.retrofit.dto.product

import com.squareup.moshi.Json

data class ProductResponse(
    @Json(name = "id")
    private val id: Long,
    @Json(name = "name")
    private val name: String,
    @Json(name = "description")
    private val description: String,
    @Json(name = "images")
    private val images: List<String>,
    @Json(name = "price")
    private val price: Long
)