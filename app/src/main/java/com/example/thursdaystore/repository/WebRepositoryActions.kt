package com.example.thursdaystore.repository

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.thursdaystore.repository.request_action.categories.GetCategoriesActionError
import com.example.thursdaystore.repository.request_action.categories.GetCategoriesActionSuccess
import com.example.thursdaystore.repository.request_action.filters.apply.ApplyFilterActionError
import com.example.thursdaystore.repository.request_action.filters.apply.ApplyFilterActionSuccess
import com.example.thursdaystore.repository.request_action.filters.get.GetFiltersActionError
import com.example.thursdaystore.repository.request_action.filters.get.GetFiltersActionSuccess
import com.example.thursdaystore.repository.request_action.products.GetProductsActionError
import com.example.thursdaystore.repository.request_action.products.GetProductsActionSuccess
import com.example.thursdaystore.repository.request_action.properties.GetPropertiesActionError
import com.example.thursdaystore.repository.request_action.properties.GetPropertiesActionSuccess
import com.example.thursdaystore.repository.request_action.subcategories.GetSubcategoriesActionError
import com.example.thursdaystore.repository.request_action.subcategories.GetSubcategoriesActionSuccess
import com.example.thursdaystore.retrofit.dto.category.CategoryResponse
import com.example.thursdaystore.retrofit.dto.filter.FilterResponse
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterRequest
import com.example.thursdaystore.retrofit.dto.product.ProductResponse
import com.example.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse

enum class WebRepositoryActions {

    INSTANCE;

    @SuppressLint("CheckResult")
    fun getLanguages() {
        WebRepositoryRequests.INSTANCE.getLanguages().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getCategories(liveData: MutableLiveData<List<CategoryResponse>>) {
        WebRepositoryRequests.INSTANCE.getCategories().subscribe(
            GetCategoriesActionSuccess(liveData),
            GetCategoriesActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getSubcategories(id: Long, liveData: MutableLiveData<List<SubcategoryResponse>>) {
        WebRepositoryRequests.INSTANCE.getSubcategories(id).subscribe(
            GetSubcategoriesActionSuccess(liveData),
            GetSubcategoriesActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getLocale() {
        WebRepositoryRequests.INSTANCE.getLocale().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getColors() {
        WebRepositoryRequests.INSTANCE.getColors().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getProducts(id: Long, liveData: MutableLiveData<List<ProductResponse>>) {
        WebRepositoryRequests.INSTANCE.getProducts(id).subscribe(
            GetProductsActionSuccess(liveData),
            GetProductsActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getProperties() {
        WebRepositoryRequests.INSTANCE.getProperties().subscribe(
            GetPropertiesActionSuccess(),
            GetPropertiesActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getParameters() {
        WebRepositoryRequests.INSTANCE.getParameters().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getFilter(id: Long, liveData: MutableLiveData<List<FilterResponse>>) {
        WebRepositoryRequests.INSTANCE.getFilter(id).subscribe(
            GetFiltersActionSuccess(
                liveData
            ),
            GetFiltersActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun applyFilter(filter: ApplyFilterRequest, liveData: MutableLiveData<List<ProductResponse>>) {
        WebRepositoryRequests.INSTANCE.applyFilter(filter).subscribe(
            ApplyFilterActionSuccess(liveData),
            ApplyFilterActionError()
        )
    }
}