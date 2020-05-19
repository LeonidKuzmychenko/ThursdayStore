package com.example.thursdaystore.fragments.sub_category

import android.view.View
import androidx.navigation.Navigation
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterRequest

class SubCategoryItemListener(private val title:String, private val catId:Long, private val item:View, private val filter: ApplyFilterRequest?): View.OnClickListener {

    override fun onClick(v: View) {
        val action = SubCategoryFragmentDirections.actionSubCategoryFragmentToProductsFragment(title, catId, filter)
        Navigation.findNavController(item).navigate(action)
    }

}