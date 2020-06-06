package my.diploma.thursdaystore.retrofit;

import io.reactivex.Single
import my.diploma.thursdaystore.retrofit.dto.category.CategoryResponse
import my.diploma.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest
import my.diploma.thursdaystore.retrofit.dto.filter.response.FilterItem
import my.diploma.thursdaystore.retrofit.dto.languages.LanguagesResponse
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse
import my.diploma.thursdaystore.retrofit.dto.properties.PropertiesResponse
import my.diploma.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse
import my.diploma.thursdaystore.retrofit.dto.user.UserData
import retrofit2.Response
import retrofit2.http.*

interface ServerRequest {

    @GET("/languages")
    fun getLanguages(): Single<Response<List<LanguagesResponse>>>

    @GET("/categories")
    fun getCategories(@Header("mac") mac:String, @Query("lang") lang: String): Single<Response<List<CategoryResponse>>>

    @GET("/subcategories")
    fun getSubcategories(@Query("catId") id: Long, @Query("lang") lang: String): Single<Response<List<SubcategoryResponse>>>

    @GET("/locale")
    fun getLocale(): Single<Response<String>>

    @GET("/colors")
    fun getColors(): Single<Response<String>>

    @GET("/products")
    fun getProducts(@Query("catId") id: Long): Single<Response<List<ProductResponse>>>

    @GET("/properties")
    fun getProperties(@Query("lang") lang: String): Single<Response<List<PropertiesResponse>>>

    @GET("/parameters")
    fun getParameters(): Single<Response<String>>

    @GET("/filter")
    fun getFilter(@Query("catId") id: Long, @Query("lang") lang: String): Single<Response<FilterItem>>

    @POST("products/filter")
    fun applyFilter(@Body filterItem: ApplyFilterItemRequest): Single<Response<List<ProductResponse>>>

    @GET("/user")
    fun getUserData(@Header("mac") mac:String): Single<Response<UserData>>

    @PUT("/user")
    fun setUserData(@Header("mac") mac:String, @Body user: UserData): Single<Response<UserData>>

}