package my.diploma.thursdaystore.drawer.favorites.adapter

import android.view.View
import my.diploma.thursdaystore.product_adapter.AbstractProductsAdapter
import my.diploma.thursdaystore.product_adapter.listeners.ProductCartClickListener
import my.diploma.thursdaystore.product_adapter.listeners.ProductFavoriteClickListener
import my.diploma.thursdaystore.product_adapter.listeners.ProductItemClickListener
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class BasketAdapter(private val list: List<ProductResponse>) : AbstractProductsAdapter(list){

    override fun getProductClickListener(position: Long, view: View): ProductItemClickListener {
        return ProductItemClickListener(position,view)
    }

    override fun getFavoriteClickListener(productId: Long): View.OnClickListener = ProductFavoriteClickListener(productId)

    override fun getCartClickListener(productId: Long): View.OnClickListener = ProductCartClickListener(productId)

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.cart.setState(true)
    }
}