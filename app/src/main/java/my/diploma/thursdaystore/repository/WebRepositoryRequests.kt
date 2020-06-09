package my.diploma.thursdaystore.repository

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import my.diploma.thursdaystore.retrofit.RetrofitApi
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
import my.diploma.thursdaystore.utils.Language
import my.diploma.thursdaystore.utils.SharedPreferencesManager
import retrofit2.Response

enum class WebRepositoryRequests {

    INSTANCE;

    fun getLanguages(): Single<Response<List<LanguagesResponse>>> =
        RetrofitApi.server().getLanguages(SharedPreferencesManager.INSTANCE.getMacAddress())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getCategories(): Single<Response<List<CategoryResponse>>> =
        RetrofitApi.server().getCategories(SharedPreferencesManager.INSTANCE.getMacAddress(), Language.getLanguage())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getSubcategories(id: Long): Single<Response<List<SubcategoryResponse>>> =
        RetrofitApi.server()
            .getSubcategories(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                id, Language.getLanguage())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getLocale(): Single<Response<List<Locale>>> =
        RetrofitApi.server()
            .getLocale(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                Language.getLanguage())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getColors(): Single<Response<String>> {
        TODO("Not yet implemented")
    }

    fun getProducts(id: Long): Single<Response<List<ProductResponse>>> =
        RetrofitApi.server()
            .getProducts(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getProduct(productId: Long): Single<Response<ProductInfoResponse>> =
        RetrofitApi.server()
            .getProduct(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                productId,
                Language.getLanguage())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getProperties(): Single<Response<List<PropertiesResponse>>> =
        RetrofitApi.server()
            .getProperties(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                Language.getLanguage())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())


    fun getParameters(): Single<Response<String>> {
        TODO("Not yet implemented")
    }

    fun getFilter(id: Long): Single<Response<FilterItem>> =
        RetrofitApi.server()
            .getFilter(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                id,
                Language.getLanguage())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun applyFilter(filterItem: ApplyFilterItemRequest): Single<Response<List<ProductResponse>>> =
        RetrofitApi.server()
            .applyFilter(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                filterItem)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getUserData(): Single<Response<UserData>> =
        RetrofitApi.server().getUserData(SharedPreferencesManager.INSTANCE.getMacAddress())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun setUserData(userData: UserData): Single<Response<UserData>> =
        RetrofitApi.server().setUserData(SharedPreferencesManager.INSTANCE.getMacAddress(), userData)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getFavorites(): Single<Response<List<ProductResponse>>> =
        RetrofitApi.server()
            .getFavorites(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                Language.getLanguage(),
                null
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun addFavorites(productId:Long): Single<Response<Any>> =
        RetrofitApi.server()
            .addFavorites(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                FavoritesRequest(productId)
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun deleteFavorites(productId:Long): Single<Response<Any>> =
        RetrofitApi.server()
            .deleteFavorites(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                FavoritesRequest(productId)
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getCart(): Single<Response<List<ProductResponse>>> =
        RetrofitApi.server()
            .getCart(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                Language.getLanguage(),
                null
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun addCart(productId:Long): Single<Response<Any>> =
        RetrofitApi.server()
            .addCart(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                CartRequest(productId)
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun deleteCart(productId:Long): Single<Response<Any>> =
        RetrofitApi.server()
            .deleteCart(
                SharedPreferencesManager.INSTANCE.getMacAddress(),
                CartRequest(productId)
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}