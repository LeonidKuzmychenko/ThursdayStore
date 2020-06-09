package my.diploma.thursdaystore.retrofit.dto.product

import com.squareup.moshi.Json

data class Property(
    @Json(name = "propertyId")
    var propertyId: Long,
    @Json(name = "propertyName")
    var propertyName: String,
    @Json(name = "parameters")
    var parameters: List<Parameter>
)