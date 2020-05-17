package com.example.thursdaystore.fragments.products

import android.view.View
import androidx.navigation.Navigation

class FilterButtonClickListener(private val title: String, private val id: Long): View.OnClickListener {
    override fun onClick(v: View) {
        val action = ProductsFragmentDirections.actionProductsFragmentToFilterFragment(title, id)
        Navigation.findNavController(v).navigate(action)
    }
}