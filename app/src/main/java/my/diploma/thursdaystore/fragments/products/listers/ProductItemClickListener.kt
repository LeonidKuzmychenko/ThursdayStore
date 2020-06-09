package my.diploma.thursdaystore.fragments.products.listers

import androidx.navigation.NavDirections
import my.diploma.thursdaystore.fragments.products.ProductsFragmentDirections
import my.diploma.thursdaystore.product_adapter.listeners.ProductItemClick

class ProductItemClickListener(private val productId: Long): ProductItemClick() {

    override fun getAction(): NavDirections {
        return ProductsFragmentDirections.actionProductsFragmentToProductInfoFragment(productId)
    }

}