package my.diploma.thursdaystore.retrofit.dto.locale

import com.squareup.moshi.Json

data class Locale(
    @Json(name = "id")
    var id: Long,
    @Json(name = "key")
    var key: String,
    @Json(name = "value")
    var value: String
)
