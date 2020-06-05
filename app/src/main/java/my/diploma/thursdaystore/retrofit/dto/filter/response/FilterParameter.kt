package my.diploma.thursdaystore.retrofit.dto.filter.response

import com.squareup.moshi.Json

data class FilterParameter(
    @Json(name = "parameterId")
    val parameterId: Long,
    @Json(name = "parameterName")
    val parameterName: String
)