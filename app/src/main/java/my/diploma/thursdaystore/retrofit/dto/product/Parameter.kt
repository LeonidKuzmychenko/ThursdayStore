package my.diploma.thursdaystore.retrofit.dto.product

import com.squareup.moshi.Json

data class Parameter(
    @Json(name = "parameterId")
    var parameterId: Long,
    @Json(name = "parameterName")
    var parameterName: String
)