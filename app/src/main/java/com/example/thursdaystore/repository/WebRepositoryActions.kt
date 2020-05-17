package com.example.thursdaystore.repository

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.thursdaystore.repository.request_action.categories.GetCategoriesActionError
import com.example.thursdaystore.repository.request_action.categories.GetCategoriesActionSuccess
import com.example.thursdaystore.repository.request_action.filters.GetFiltersActionError
import com.example.thursdaystore.repository.request_action.filters.GetFiltersActionSuccess
import com.example.thursdaystore.repository.request_action.products.GetProductsActionError
import com.example.thursdaystore.repository.request_action.products.GetProductsActionSuccess
import com.example.thursdaystore.repository.request_action.subcategories.GetSubcategoriesActionError
import com.example.thursdaystore.repository.request_action.subcategories.GetSubcategoriesActionSuccess
import com.example.thursdaystore.retrofit.dto.category.CategoryResponse
import com.example.thursdaystore.retrofit.dto.product.ProductResponse
import com.example.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse

enum class WebRepositoryActions {

    INSTANCE;

    @SuppressLint("CheckResult")
    fun getLanguages(){
        WebRepositoryRequests.INSTANCE.getLanguages().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getCategories(liveData: MutableLiveData<List<CategoryResponse>>){
        WebRepositoryRequests.INSTANCE.getCategories().subscribe(
            GetCategoriesActionSuccess(liveData),
            GetCategoriesActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getSubcategories(id: Long, liveData: MutableLiveData<List<SubcategoryResponse>>){
        WebRepositoryRequests.INSTANCE.getSubcategories(id).subscribe(
            GetSubcategoriesActionSuccess(liveData),
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
    fun getProducts(id: Long, liveData: MutableLiveData<List<ProductResponse>>){
        WebRepositoryRequests.INSTANCE.getProducts(id).subscribe(
            GetProductsActionSuccess(liveData),
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
    fun getFilter(id: Long){
        WebRepositoryRequests.INSTANCE.getFilter(id).subscribe(
            GetFiltersActionSuccess(),
            GetFiltersActionError()
        )
    }
}