package my.diploma.thursdaystore.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.fragment.app.Fragment
import my.diploma.thursdaystore.activities.StartActivity
import my.diploma.thursdaystore.drawer.basket.BasketFragment
import my.diploma.thursdaystore.drawer.category.CategoryFragment
import my.diploma.thursdaystore.drawer.favorites.FavoritesFragment
import my.diploma.thursdaystore.drawer.purchases.PurchasesFragment
import my.diploma.thursdaystore.fragments.filter.FilterFragment
import my.diploma.thursdaystore.fragments.make_purchase.MakePurchaseFragment
import my.diploma.thursdaystore.fragments.product_tree.ProductInfoFragment
import my.diploma.thursdaystore.fragments.products.ProductsFragment
import my.diploma.thursdaystore.fragments.sub_category.SubCategoryFragment
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
import my.diploma.thursdaystore.repository.request_action.locale.GetLocaleActionError
import my.diploma.thursdaystore.repository.request_action.locale.GetLocaleActionSuccess
import my.diploma.thursdaystore.repository.request_action.product.GetProductInfoActionError
import my.diploma.thursdaystore.repository.request_action.product.GetProductInfoActionSuccess
import my.diploma.thursdaystore.repository.request_action.products.GetProductsActionError
import my.diploma.thursdaystore.repository.request_action.products.GetProductsActionSuccess
import my.diploma.thursdaystore.repository.request_action.properties.GetPropertiesActionError
import my.diploma.thursdaystore.repository.request_action.properties.GetPropertiesActionSuccess
import my.diploma.thursdaystore.repository.request_action.purchase.get.GetPurchasesActionError
import my.diploma.thursdaystore.repository.request_action.purchase.get.GetPurchasesActionSuccess
import my.diploma.thursdaystore.repository.request_action.purchase.post.MakePurchaseActionError
import my.diploma.thursdaystore.repository.request_action.purchase.post.MakePurchaseActionSuccess
import my.diploma.thursdaystore.repository.request_action.subcategories.GetSubcategoriesActionError
import my.diploma.thursdaystore.repository.request_action.subcategories.GetSubcategoriesActionSuccess
import my.diploma.thursdaystore.repository.request_action.user.get.GetUserDataActionError
import my.diploma.thursdaystore.repository.request_action.user.get.GetUserDataActionSuccess
import my.diploma.thursdaystore.repository.request_action.user.set.SetUserDataActionError
import my.diploma.thursdaystore.repository.request_action.user.set.SetUserDataActionSuccess
import my.diploma.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest
import my.diploma.thursdaystore.retrofit.dto.purchases.post.MakePurchaseRequest
import my.diploma.thursdaystore.retrofit.dto.user.UserData

enum class WebRepositoryActions {

    INSTANCE;

    @SuppressLint("CheckResult")
    fun getLanguages() {
        WebRepositoryRequests.INSTANCE.getLanguages().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getCategories(f:CategoryFragment) {
        WebRepositoryRequests.INSTANCE.getCategories().subscribe(
            GetCategoriesActionSuccess(f),
            GetCategoriesActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getSubcategories(f:SubCategoryFragment, id: Long) {
        WebRepositoryRequests.INSTANCE.getSubcategories(id).subscribe(
            GetSubcategoriesActionSuccess(f),
            GetSubcategoriesActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getLocale(activity: StartActivity?) {
        WebRepositoryRequests.INSTANCE.getLocale().subscribe(
            GetLocaleActionSuccess(activity),
            GetLocaleActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getColors() {
        WebRepositoryRequests.INSTANCE.getColors().subscribe()
    }

    @SuppressLint("CheckResult")
    fun getProducts(f:ProductsFragment, id: Long) {
        WebRepositoryRequests.INSTANCE.getProducts(id).subscribe(
            GetProductsActionSuccess(f),
            GetProductsActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getProduct(f:ProductInfoFragment, productId: Long) {
        WebRepositoryRequests.INSTANCE.getProduct(productId).subscribe(
            GetProductInfoActionSuccess(f),
            GetProductInfoActionError()
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
    fun getFilter(f:FilterFragment, id: Long) {
        WebRepositoryRequests.INSTANCE.getFilter(id).subscribe(
            GetFiltersActionSuccess(f),
            GetFiltersActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun applyFilter(f:ProductsFragment,filterItem: ApplyFilterItemRequest) {
        Log.d("USELESS_FILTER", "$filterItem")
        WebRepositoryRequests.INSTANCE.applyFilter(filterItem).subscribe(
            ApplyFilterActionSuccess(f),
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
    fun setUserData(f:Fragment, userData: UserData){
        WebRepositoryRequests.INSTANCE.setUserData(userData).subscribe(
            SetUserDataActionSuccess(f),
            SetUserDataActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun getFavorites(f:FavoritesFragment){
        WebRepositoryRequests.INSTANCE.getFavorites().subscribe(
            GetFavoritesActionSuccess(f),
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
    fun getCart(f:BasketFragment){
        WebRepositoryRequests.INSTANCE.getCart().subscribe(
            GetCartActionSuccess(f),
            GetCartActionError()
        )
    }

    fun addCart(productId:Long){
        WebRepositoryRequests.INSTANCE.addCart(productId).subscribe()
    }

    fun deleteCart(productId:Long){
        WebRepositoryRequests.INSTANCE.deleteCart(productId).subscribe()
    }

    @SuppressLint("CheckResult")
    fun getPurchases(f: PurchasesFragment){
        WebRepositoryRequests.INSTANCE.getPurchases().subscribe(
            GetPurchasesActionSuccess(f),
            GetPurchasesActionError()
        )
    }

    @SuppressLint("CheckResult")
    fun makePurchase(f: MakePurchaseFragment, purchase: MakePurchaseRequest){
        WebRepositoryRequests.INSTANCE.makePurchase(purchase).subscribe(
            MakePurchaseActionSuccess(f),
            MakePurchaseActionError()
        )
    }

}

