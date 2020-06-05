package my.diploma.thursdaystore.retrofit.dto.user

import com.squareup.moshi.Json

data class UserData(
    @Json(name = "id")
    var id: Long? = null,
    @Json(name = "mac")
    var mac: String? = null,
    @Json(name = "name")
    var name: String? = null,
    @Json(name = "lastName")
    var lastName: String? = null,
    @Json(name = "patronymic")
    var patronymic: String? = null,
    @Json(name = "email")
    var email: String? = null,
    @Json(name = "gender")
    var gender: String? = null,
    @Json(name = "birthDay")
    var birthDay: String? = null,
    @Json(name = "phone")
    var phone: String? = null,
    @Json(name = "city")
    var city: String? = null,
    @Json(name = "address")
    var address: String? = null
)