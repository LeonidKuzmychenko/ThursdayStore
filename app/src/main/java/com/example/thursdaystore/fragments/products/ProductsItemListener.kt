package com.example.thursdaystore.fragments.products

import android.view.View
import androidx.navigation.Navigation

class ProductsItemListener(private val pos:Long, private val item:View): View.OnClickListener{

    override fun onClick(v: View) {
        val actionProductsFragmentToProductTreeFragment = ProductsFragmentDirections.actionProductsFragmentToProductTreeFragment()
        actionProductsFragmentToProductTreeFragment.productId = pos
        Navigation.findNavController(item).navigate(actionProductsFragmentToProductTreeFragment)
    }

}