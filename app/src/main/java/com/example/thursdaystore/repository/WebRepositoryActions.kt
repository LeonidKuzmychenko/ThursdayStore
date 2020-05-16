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

    @SuppressLint("CheckResult")
    fun getLanguages(){
        WebRepositoryRequests.INSTANCE.getLanguages().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getCategories(lang: String){
        WebRepositoryRequests.INSTANCE.getCategories(lang).subscribe(
            GetCategoriesActionSuccess(),
            GetCategoriesActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getSubcategories(id: Long){
        WebRepositoryRequests.INSTANCE.getSubcategories(id).subscribe(
            GetSubcategoriesActionSuccess(),
            GetSubcategoriesActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getLocale(){
        WebRepositoryRequests.INSTANCE.getLocale().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getColors(){
        WebRepositoryRequests.INSTANCE.getColors().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getProducts(id: Long){
        WebRepositoryRequests.INSTANCE.getProducts(id).subscribe(
            GetProductsActionSuccess(),
            GetProductsActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getProperties(){
        WebRepositoryRequests.INSTANCE.getProperties().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getParameters(){
        WebRepositoryRequests.INSTANCE.getParameters().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getFilter(id: Long, lang: String){
        WebRepositoryRequests.INSTANCE.getFilter(id,lang).subscribe(
            GetFiltersActionSuccess(),
            GetFiltersActionError()
        )
    }
}