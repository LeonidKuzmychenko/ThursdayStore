package my.diploma.thursdaystore.retrofit.dto.filter.response

import com.squareup.moshi.Json

data class FilterProperties(
    @Json(name = "propertyId")
    val propertyId: Long,
    @Json(name = "propertyName")
    val propertyName: String,
    @Json(name = "parameters")
    val filterParameters: List<FilterParameter>
)