package my.diploma.thursdaystore.retrofit;

import io.reactivex.Single
import my.diploma.thursdaystore.retrofit.dto.category.CategoryResponse
import my.diploma.thursdaystore.retrofit.dto.favorites.CartRequest
import my.diploma.thursdaystore.retrofit.dto.favorites.FavoritesRequest
import my.diploma.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest
import my.diploma.thursdaystore.retrofit.dto.filter.response.FilterItem
import my.diploma.thursdaystore.retrofit.dto.languages.LanguagesResponse
import my.diploma.thursdaystore.retrofit.dto.locale.Locale
import my.diploma.thursdaystore.retrofit.dto.product.ProductInfoResponse
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse
import my.diploma.thursdaystore.retrofit.dto.properties.PropertiesResponse
import my.diploma.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse
import my.diploma.thursdaystore.retrofit.dto.user.UserData
import retrofit2.Response
import retrofit2.http.*

interface ServerRequest {

    @GET("/languages")
    fun getLanguages(@Header("mac") mac:String): Single<Response<List<LanguagesResponse>>>

    @GET("/categories")
    fun getCategories(@Header("mac") mac:String,
                      @Query("lang") lang: String): Single<Response<List<CategoryResponse>>>

    @GET("/subcategories")
    fun getSubcategories(@Header("mac") mac:String,
                         @Query("catId") id: Long,
                         @Query("lang") lang: String): Single<Response<List<SubcategoryResponse>>>

    @GET("/locale")
    fun getLocale(@Header("mac") mac:String, @Query("lang") lang: String): Single<Response<List<Locale>>>

    @GET("/colors")
    fun getColors(@Header("mac") mac:String): Single<Response<String>>

    @GET("/products")
    fun getProducts(@Header("mac") mac:String,
                    @Query("catId") id: Long): Single<Response<List<ProductResponse>>>

    @GET("/products/{id}")
    fun getProduct(@Header("mac") mac:String,
                   @Path("id") productId: Long,
                   @Query("lang") lang: String): Single<Response<ProductInfoResponse>>

    @GET("/properties")
    fun getProperties(@Header("mac") mac:String,
                      @Query("lang") lang: String): Single<Response<List<PropertiesResponse>>>

    @GET("/parameters")
    fun getParameters(@Header("mac") mac:String): Single<Response<String>>

    @GET("/filter")
    fun getFilter(@Header("mac") mac:String,
                  @Query("catId") id: Long,
                  @Query("lang") lang: String): Single<Response<FilterItem>>

    @POST("products/filter")
    fun applyFilter(@Header("mac") mac:String,
                    @Body filterItem: ApplyFilterItemRequest): Single<Response<List<ProductResponse>>>

    @GET("/user")
    fun getUserData(@Header("mac") mac:String): Single<Response<UserData>>

    @PUT("/user")
    fun setUserData(@Header("mac") mac:String,
                    @Body user: UserData): Single<Response<UserData>>

    @GET("/favorite")
    fun getFavorites(@Header("mac") mac:String,
                     @Query("lang") lang: String,
                     @Query("currency") currency :String?): Single<Response<List<ProductResponse>>>

    @POST("/favorite")
    fun addFavorites(@Header("mac") mac:String,
                     @Body fav:FavoritesRequest): Single<Response<Any>>

    @HTTP(method = "DELETE", path = "/favorite", hasBody = true)
    fun deleteFavorites(@Header("mac") mac:String,
                        @Body fav:FavoritesRequest): Single<Response<Any>>

    @GET("/cart")
    fun getCart(@Header("mac") mac:String,
                     @Query("lang") lang: String,
                     @Query("currency") currency :String?): Single<Response<List<ProductResponse>>>

    @POST("/cart")
    fun addCart(@Header("mac") mac:String,
                @Body fav:CartRequest): Single<Response<Any>>

    @HTTP(method = "DELETE", path = "/cart", hasBody = true)
    fun deleteCart(@Header("mac") mac:String,
                   @Body fav:CartRequest): Single<Response<Any>>
}