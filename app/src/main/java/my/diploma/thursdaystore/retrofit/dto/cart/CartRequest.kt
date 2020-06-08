package my.diploma.thursdaystore.retrofit.dto.favorites

import com.squareup.moshi.Json

data class CartRequest(
    @Json(name = "productId")
    val productId: Long
)