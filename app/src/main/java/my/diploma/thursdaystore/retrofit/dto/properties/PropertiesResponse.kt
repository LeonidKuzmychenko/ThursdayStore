package my.diploma.thursdaystore.retrofit.dto.properties

import com.squareup.moshi.Json

data class PropertiesResponse(
    @Json(name = "id")
    var id: Long,
    @Json(name = "name")
    var name: String
)