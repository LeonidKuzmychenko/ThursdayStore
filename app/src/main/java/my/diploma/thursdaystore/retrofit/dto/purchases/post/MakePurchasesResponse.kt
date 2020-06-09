package my.diploma.thursdaystore.retrofit.dto.purchases.post

import com.squareup.moshi.Json
import my.diploma.thursdaystore.retrofit.dto.purchases.Product

class MakePurchasesResponse(
    @Json(name = "id")
    var id: Long,
    @Json(name = "status")
    var status: String,
    @Json(name = "deliveryType")
    var deliveryType: String,
    @Json(name = "address")
    var address: String,
    @Json(name = "date")
    var date: String,
    @Json(name = "bill")
    var bill: String,
    @Json(name = "products")
    var products: List<Product>
)