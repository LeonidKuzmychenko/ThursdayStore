package com.example.thursdaystore.fragments.products.listers

import android.view.View
import androidx.navigation.Navigation
import com.example.thursdaystore.fragments.products.ProductsFragmentDirections
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest

class FilterButtonClickListener(private val title: String, private val id: Long, private val filterItem: ApplyFilterItemRequest?): View.OnClickListener {
    override fun onClick(v: View) {
        val action =
            ProductsFragmentDirections.actionProductsFragmentToFilterFragment(
                title,
                id,
                filterItem
            )
        Navigation.findNavController(v).navigate(action)
    }
}