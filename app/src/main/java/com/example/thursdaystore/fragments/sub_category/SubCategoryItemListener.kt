package com.example.thursdaystore.fragments.sub_category

import android.view.View
import androidx.navigation.Navigation

class SubCategoryItemListener(private val title:String, private val catId:Long,  private val item:View): View.OnClickListener {

    override fun onClick(v: View) {
        val action = SubCategoryFragmentDirections.actionSubCategoryFragmentToProductsFragment(title, catId)
        Navigation.findNavController(item).navigate(action)
    }

}