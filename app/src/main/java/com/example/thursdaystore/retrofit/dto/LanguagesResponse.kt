package com.example.thursdaystore.retrofit.dto

import com.squareup.moshi.Json

data class LanguagesResponse(
    @Json(name = "id")
    private val id: Long,
    @Json(name = "key")
    private val key: String,
    @Json(name = "name")
    private val name: String
)