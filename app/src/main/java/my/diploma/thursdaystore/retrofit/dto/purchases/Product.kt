package my.diploma.thursdaystore.retrofit.dto.purchases

import com.squareup.moshi.Json

data class Product(
    @Json(name = "id")
    var id: Long,
    @Json(name = "name")
    var name: String,
    @Json(name = "description")
    var description: String,
    @Json(name = "price")
    var price: String,
    @Json(name = "images")
    var images: List<String>
)