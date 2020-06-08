package my.diploma.thursdaystore.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import my.diploma.thursdaystore.repository.request_action.cart.get.GetCartActionError
import my.diploma.thursdaystore.repository.request_action.cart.get.GetCartActionSuccess
import my.diploma.thursdaystore.repository.request_action.categories.GetCategoriesActionError
import my.diploma.thursdaystore.repository.request_action.categories.GetCategoriesActionSuccess
import my.diploma.thursdaystore.repository.request_action.favorites.GetFavoritesActionError
import my.diploma.thursdaystore.repository.request_action.favorites.GetFavoritesActionSuccess
import my.diploma.thursdaystore.repository.request_action.filters.apply.ApplyFilterActionError
import my.diploma.thursdaystore.repository.request_action.filters.apply.ApplyFilterActionSuccess
import my.diploma.thursdaystore.repository.request_action.filters.get.GetFiltersActionError
import my.diploma.thursdaystore.repository.request_action.filters.get.GetFiltersActionSuccess
import my.diploma.thursdaystore.repository.request_action.products.GetProductsActionError
import my.diploma.thursdaystore.repository.request_action.products.GetProductsActionSuccess
import my.diploma.thursdaystore.repository.request_action.properties.GetPropertiesActionError
import my.diploma.thursdaystore.repository.request_action.properties.GetPropertiesActionSuccess
import my.diploma.thursdaystore.repository.request_action.subcategories.GetSubcategoriesActionError
import my.diploma.thursdaystore.repository.request_action.subcategories.GetSubcategoriesActionSuccess
import my.diploma.thursdaystore.repository.request_action.user.get.GetUserDataActionError
import my.diploma.thursdaystore.repository.request_action.user.get.GetUserDataActionSuccess
import my.diploma.thursdaystore.repository.request_action.user.set.SetUserDataActionError
import my.diploma.thursdaystore.repository.request_action.user.set.SetUserDataActionSuccess
import my.diploma.thursdaystore.retrofit.dto.category.CategoryResponse
import my.diploma.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest
import my.diploma.thursdaystore.retrofit.dto.filter.response.FilterItem
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse
import my.diploma.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse
import my.diploma.thursdaystore.retrofit.dto.user.UserData

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
    fun getFilter(id: Long, liveData: MutableLiveData<FilterItem>) {
        WebRepositoryRequests.INSTANCE.getFilter(id).subscribe(
            GetFiltersActionSuccess(
                liveData
            ),
            GetFiltersActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun applyFilter(filterItem: ApplyFilterItemRequest, liveData: MutableLiveData<List<ProductResponse>>) {
        Log.d("USELESS_FILTER", "$filterItem")
        WebRepositoryRequests.INSTANCE.applyFilter(filterItem).subscribe(
            ApplyFilterActionSuccess(liveData),
            ApplyFilterActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getUserData(){
        WebRepositoryRequests.INSTANCE.getUserData().subscribe(
            GetUserDataActionSuccess(),
            GetUserDataActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun setUserData(activity:FragmentActivity?, userData: UserData){
        WebRepositoryRequests.INSTANCE.setUserData(userData).subscribe(
            SetUserDataActionSuccess(activity),
            SetUserDataActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getFavorites(liveData: MutableLiveData<List<ProductResponse>>){
        WebRepositoryRequests.INSTANCE.getFavorites().subscribe(
            GetFavoritesActionSuccess(liveData),
            GetFavoritesActionError()
        )
    }

    fun addFavorites(productId:Long){
        WebRepositoryRequests.INSTANCE.addFavorites(productId).subscribe()
    }

    fun deleteFavorites(productId:Long){
        WebRepositoryRequests.INSTANCE.deleteFavorites(productId).subscribe()
    }

    @SuppressLint("CheckResult")
    fun getCart(liveData: MutableLiveData<List<ProductResponse>>){
        WebRepositoryRequests.INSTANCE.getCart().subscribe(
            GetCartActionSuccess(
                liveData
            ),
            GetCartActionError()
        )
    }

    fun addCart(productId:Long){
        WebRepositoryRequests.INSTANCE.addCart(productId).subscribe()
    }

    fun deleteCart(productId:Long){
        WebRepositoryRequests.INSTANCE.deleteCart(productId).subscribe()
    }
}

