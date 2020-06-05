package my.diploma.thursdaystore.retrofit.dto.languages

import com.squareup.moshi.Json

data class LanguagesResponse(
    @Json(name = "id")
    private val id: Long,
    @Json(name = "key")
    private val key: String,
    @Json(name = "name")
    private val name: String
)