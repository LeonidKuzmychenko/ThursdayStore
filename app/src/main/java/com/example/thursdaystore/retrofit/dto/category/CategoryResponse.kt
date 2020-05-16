package com.example.thursdaystore.retrofit.dto.category

import com.squareup.moshi.Json

data class CategoryResponse(
    @Json(name = "id")
    private val id: Long,
    @Json(name = "name")
    private val name: String,
    @Json(name = "image")
    private val image: Any
)