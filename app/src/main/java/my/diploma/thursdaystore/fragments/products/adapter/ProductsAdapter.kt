package my.diploma.thursdaystore.fragments.products.adapter

import android.view.View
import my.diploma.thursdaystore.product_adapter.AbstractProductsAdapter
import my.diploma.thursdaystore.product_adapter.listeners.ProductCartClickListener
import my.diploma.thursdaystore.product_adapter.listeners.ProductFavoriteClickListener
import my.diploma.thursdaystore.product_adapter.listeners.ProductItemClickListener
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class ProductsAdapter(list: List<ProductResponse>) : AbstractProductsAdapter(list){

    override fun getProductClickListener(position: Long, view: View): ProductItemClickListener {
        return ProductItemClickListener(position,view)
    }

    override fun getFavoriteClickListener(productId: Long): View.OnClickListener = ProductFavoriteClickListener(productId)

    override fun getCartClickListener(productId: Long): View.OnClickListener = ProductCartClickListener(productId)


}