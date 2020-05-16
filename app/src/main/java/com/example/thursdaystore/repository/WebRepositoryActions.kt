package com.example.thursdaystore.repository

import android.annotation.SuppressLint
import com.example.thursdaystore.repository.request_action.categories.GetCategoriesActionError
import com.example.thursdaystore.repository.request_action.categories.GetCategoriesActionSuccess
import com.example.thursdaystore.repository.request_action.filters.GetFiltersActionError
import com.example.thursdaystore.repository.request_action.filters.GetFiltersActionSuccess
import com.example.thursdaystore.repository.request_action.products.GetProductsActionError
import com.example.thursdaystore.repository.request_action.products.GetProductsActionSuccess
import com.example.thursdaystore.repository.request_action.subcategories.GetSubcategoriesActionError
import com.example.thursdaystore.repository.request_action.subcategories.GetSubcategoriesActionSuccess

enum class WebRepositoryActions {

    INSTANCE;

    private val requests: WebRepositoryRequests = WebRepositoryRequests.INSTANCE

    @SuppressLint("CheckResult")
    fun getLanguages(){
        requests.getLanguages().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getCategories(lang: String){
        requests.getCategories(lang).subscribe(
            GetCategoriesActionSuccess(),
            GetCategoriesActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getSubcategories(id: Long){
        requests.getSubcategories(id).subscribe(
            GetSubcategoriesActionSuccess(),
            GetSubcategoriesActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getLocale(){
        requests.getLocale().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getColors(){
        requests.getColors().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getProducts(id: Long){
        requests.getProducts(id).subscribe(
            GetProductsActionSuccess(),
            GetProductsActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getProperties(){
        requests.getProperties().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getParameters(){
        requests.getParameters().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getFilter(id: Long, lang: String){
        requests.getFilter(id,lang).subscribe(
            GetFiltersActionSuccess(),
            GetFiltersActionError()
        )
    }
}