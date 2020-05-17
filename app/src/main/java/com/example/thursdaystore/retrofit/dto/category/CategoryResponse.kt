package com.example.thursdaystore.retrofit.dto.category

import com.squareup.moshi.Json

data class CategoryResponse(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String,
    @Json(name = "image")
    val image: Any
)