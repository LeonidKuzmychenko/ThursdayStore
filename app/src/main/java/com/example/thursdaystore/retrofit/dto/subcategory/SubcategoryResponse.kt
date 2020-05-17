package com.example.thursdaystore.retrofit.dto.subcategory

import com.squareup.moshi.Json

data class SubcategoryResponse(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String,
    @Json(name = "image")
    val image: Any
)