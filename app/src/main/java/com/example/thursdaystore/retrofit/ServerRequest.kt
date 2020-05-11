package com.example.thursdaystore.retrofit;

import com.example.thursdaystore.retrofit.dto.GetLanguagesResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ServerRequest {
    /*-------------------------------------------languages--------------------------------------------*/
    @GET("/languages")
    fun getLanguages(): Single<Response<List<GetLanguagesResponse>>>

//    @POST("/languages")
//    fun languagesPOST(): Single<Response<String>>
//
//    @PUT("/languages")
//    fun languagesPUT(): Single<Response<String>>
//
//    @DELETE("/languages")
//    fun languagesDELETE(): Single<Response<String>>

    /*-------------------------------------------categories-------------------------------------------*/
    @GET("/categories")
    fun getCategories(): Single<Response<String>>

//    @POST("/categories")
//    fun categoriesPOST(): Single<Response<String>>
//
//    @PUT("/categories")
//    fun categoriesPUT(): Single<Response<String>>
//
//    @DELETE("/categories")
//    fun categoriesDELETE(): Single<Response<String>>

    /*------------------------------------------subcategories-----------------------------------------*/
    @GET("/subcategories")
    fun getSubcategories(): Single<Response<String>>

//    @POST("/subcategories")
//    fun subcategoriesPOST(): Single<Response<String>>
//
//    @PUT("/subcategories")
//    fun subcategoriesPUT(): Single<Response<String>>
//
//    @DELETE("/subcategories")
//    fun subcategoriesDELETE(): Single<Response<String>>

    /*----------------------------------------------admin---------------------------------------------*/
//    @POST("/admin/initial")
//    fun admin(): Single<Response<String>>

    /*---------------------------------------------locale---------------------------------------------*/
    @GET("/locale")
    fun getLocale(): Single<Response<String>>

//    @POST("/locale")
//    fun localePOST(): Single<Response<String>>
//
//    @PUT("/locale")
//    fun localePUT(): Single<Response<String>>
//
//    @DELETE("/locale")
//    fun localeDELETE(): Single<Response<String>>

    /*---------------------------------------------colors---------------------------------------------*/
    @GET("/colors")
    fun getColors(): Single<Response<String>>

//    @POST("/colors")
//    fun colorsPOST(): Single<Response<String>>
//
//    @PUT("/colors")
//    fun colorsPUT(): Single<Response<String>>
//
//    @DELETE("/colors")
//    fun colorsDELETE(): Single<Response<String>>

    /*--------------------------------------------products--------------------------------------------*/
    @GET("/products")
    fun getProducts(): Single<Response<String>>

//    @POST("/products")
//    fun productsPOST(): Single<Response<String>>
//
//    @PUT("/products")
//    fun productsPUT(): Single<Response<String>>
//
//    @DELETE("/products")
//    fun productsDELETE(): Single<Response<String>>

    /*-------------------------------------------properties-------------------------------------------*/
    @GET("/properties")
    fun getProperties(): Single<Response<String>>

//    @POST("/properties")
//    fun propertiesPOST(): Single<Response<String>>
//
//    @PUT("/properties")
//    fun propertiesPUT(): Single<Response<String>>
//
//    @DELETE("/properties")
//    fun propertiesDELETE(): Single<Response<String>>

    /*-------------------------------------------parameters-------------------------------------------*/
    @GET("/parameters")
    fun getParameters(): Single<Response<String>>

//    @POST("/parameters")
//    fun parametersPOST(): Single<Response<String>>
//
//    @PUT("/parameters")
//    fun parametersPUT(): Single<Response<String>>
//
//    @DELETE("/parameters")
//    fun parametersDELETE(): Single<Response<String>>
}