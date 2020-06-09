package my.diploma.thursdaystore.retrofit.dto.filter.request

import com.squareup.moshi.Json
import java.io.Serializable

data class ApplyFilterItemRequest(
    @Json(name = "catId")
    val catId: Long,
    @Json(name = "lang")
    val lang: String,
    @Json(name = "prices")
    val price:FilterPricesRequest,
    @Json(name = "filters")
    val filters: List<FilterPropertyRequest> = listOf()
) : Serializable