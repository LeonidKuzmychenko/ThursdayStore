package my.diploma.thursdaystore.drawer.favorites.adapter

import android.view.View
import my.diploma.thursdaystore.drawer.favorites.listener.FavoriteProductItemClickListener
import my.diploma.thursdaystore.product_adapter.AbstractProductsAdapter
import my.diploma.thursdaystore.product_adapter.listeners.ProductCartClickListener
import my.diploma.thursdaystore.product_adapter.listeners.ProductFavoriteClickListener
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class FavoritesAdapter(private val list: List<ProductResponse>) : AbstractProductsAdapter(list){

    override fun getProductClickListener(productId: Long) = FavoriteProductItemClickListener(productId)

    override fun getFavoriteClickListener(productId: Long): View.OnClickListener = ProductFavoriteClickListener(productId)

    override fun getCartClickListener(productId: Long): View.OnClickListener = ProductCartClickListener(productId)

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.favorite.setState(true)
    }


}