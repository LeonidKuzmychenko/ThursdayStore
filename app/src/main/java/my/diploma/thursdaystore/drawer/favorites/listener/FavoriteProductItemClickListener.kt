package my.diploma.thursdaystore.drawer.favorites.listener

import androidx.navigation.NavDirections
import my.diploma.thursdaystore.drawer.favorites.FavoritesFragmentDirections
import my.diploma.thursdaystore.product_adapter.listeners.ProductItemClick

class FavoriteProductItemClickListener(private val productId: Long): ProductItemClick(){

    override fun getAction(): NavDirections {
        return FavoritesFragmentDirections.actionNavFavoritesToProductInfoFragment(productId)
    }

}