package com.example.thursdaystore.repository

import com.example.thursdaystore.retrofit.RetrofitApi
import com.example.thursdaystore.retrofit.dto.category.CategoryResponse
import com.example.thursdaystore.retrofit.dto.filter.FilterResponse
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterRequest
import com.example.thursdaystore.retrofit.dto.languages.LanguagesResponse
import com.example.thursdaystore.retrofit.dto.product.ProductResponse
import com.example.thursdaystore.retrofit.dto.properties.PropertiesResponse
import com.example.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse
import com.example.thursdaystore.utils.Language
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

enum class WebRepositoryRequests {

    INSTANCE;

    fun getLanguages(): Single<Response<List<LanguagesResponse>>> =
        RetrofitApi.server().getLanguages()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getCategories(): Single<Response<List<CategoryResponse>>> =
        RetrofitApi.server().getCategories(Language.getLanguage())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getSubcategories(id: Long): Single<Response<List<SubcategoryResponse>>> =
        RetrofitApi.server().getSubcategories(id, Language.getLanguage())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getLocale(): Single<Response<String>> {
        TODO("Not yet implemented")
    }

    fun getColors(): Single<Response<String>> {
        TODO("Not yet implemented")
    }

    fun getProducts(id: Long): Single<Response<List<ProductResponse>>> =
        RetrofitApi.server().getProducts(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getProperties(): Single<Response<List<PropertiesResponse>>> =
        RetrofitApi.server().getProperties(Language.getLanguage())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())


    fun getParameters(): Single<Response<String>> {
        TODO("Not yet implemented")
    }

    fun getFilter(id: Long): Single<Response<List<FilterResponse>>> =
        RetrofitApi.server().getFilter(id, Language.getLanguage())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun applyFilter(filter: ApplyFilterRequest): Single<Response<List<ProductResponse>>> =
        RetrofitApi.server().applyFilter(filter)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}