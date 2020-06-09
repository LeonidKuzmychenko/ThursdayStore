package my.diploma.thursdaystore.drawer.favorites.listener

import androidx.navigation.NavDirections
import my.diploma.thursdaystore.drawer.basket.BasketFragmentDirections
import my.diploma.thursdaystore.product_adapter.listeners.ProductItemClick

class BasketProductItemClickListener(private val productId: Long): ProductItemClick(){

    override fun getAction(): NavDirections {
        return BasketFragmentDirections.actionNavBasketToProductInfoFragment(productId)
    }

}