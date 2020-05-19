package com.example.thursdaystore.fragments.products

import android.view.View
import androidx.navigation.Navigation
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterRequest

class FilterButtonClickListener(private val title: String, private val id: Long, private val filter: ApplyFilterRequest?): View.OnClickListener {
    override fun onClick(v: View) {
        val action = ProductsFragmentDirections.actionProductsFragmentToFilterFragment(title, id, filter)
        Navigation.findNavController(v).navigate(action)
    }
}