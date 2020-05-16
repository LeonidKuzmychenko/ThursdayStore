package com.example.thursdaystore.retrofit.dto

import com.squareup.moshi.Json

class SubcategoryResponse(
    @Json(name = "id")
    private val id: Long,
    @Json(name = "name")
    private val name: String,
    @Json(name = "image")
    private val image: Any
)