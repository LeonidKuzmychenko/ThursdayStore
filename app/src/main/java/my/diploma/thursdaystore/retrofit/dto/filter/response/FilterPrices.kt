package my.diploma.thursdaystore.retrofit.dto.filter.response

import com.squareup.moshi.Json

data class FilterPrices(
    @Json(name = "max")
    val max: String
)