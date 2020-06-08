package my.diploma.thursdaystore.retrofit.dto.favorites

import com.squareup.moshi.Json

data class FavoritesRequest(
    @Json(name = "productId")
    val productId: Long
)