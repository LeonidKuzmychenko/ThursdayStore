package my.diploma.thursdaystore.retrofit.dto.purchases.post

import com.squareup.moshi.Json

data class MakePurchaseRequest(
    @Json(name = "currency")
    val currency: String?,
    @Json(name = "lang")
    val lang: String?,
    @Json(name = "address")
    val address: String,
    @Json(name = "deliveryType")
    val deliveryType: String
)