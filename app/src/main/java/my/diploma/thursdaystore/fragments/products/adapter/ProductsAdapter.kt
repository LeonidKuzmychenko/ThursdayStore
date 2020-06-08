package my.diploma.thursdaystore.fragments.products.adapter

import android.view.View
import my.diploma.thursdaystore.product_adapter.AbstractProductsAdapter
import my.diploma.thursdaystore.product_adapter.listeners.ProductItemClickListener
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class ProductsAdapter(private val list: List<ProductResponse>) : AbstractProductsAdapter(list){

    override fun getProductClickListener(position: Long, view: View): ProductItemClickListener {
        return ProductItemClickListener(position,view)
    }


}