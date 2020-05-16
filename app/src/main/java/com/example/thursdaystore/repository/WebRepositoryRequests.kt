package com.example.thursdaystore.repository

import com.example.thursdaystore.retrofit.RetrofitApi
import com.example.thursdaystore.retrofit.ServerRequest
import com.example.thursdaystore.retrofit.dto.category.CategoryResponse
import com.example.thursdaystore.retrofit.dto.languages.LanguagesResponse
import com.example.thursdaystore.retrofit.dto.product.ProductResponse
import com.example.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse
import com.example.thursdaystore.retrofit.dto.filter.FilterResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

enum class WebRepositoryRequests {

    INSTANCE;

    private val server: ServerRequest = RetrofitApi.server()

    fun getLanguages(): Single<Response<List<LanguagesResponse>>> =
        server.getLanguages()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())


    fun getCategories(lang: String): Single<Response<List<CategoryResponse>>> =
        server.getCategories(lang)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getSubcategories(id: Long): Single<Response<List<SubcategoryResponse>>> =
        server.getSubcategories(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getLocale(): Single<Response<String>> {
        TODO("Not yet implemented")
    }

    fun getColors(): Single<Response<String>> {
        TODO("Not yet implemented")
    }

    fun getProducts(id: Long): Single<Response<List<ProductResponse>>> =
        server.getProducts(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getProperties(): Single<Response<String>> {
        TODO("Not yet implemented")
    }

    fun getParameters(): Single<Response<String>> {
        TODO("Not yet implemented")
    }

    fun getFilter(id: Long, lang: String): Single<Response<List<FilterResponse>>> =
        server.getFilter(id, lang)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

}