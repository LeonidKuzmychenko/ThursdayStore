package com.example.thursdaystore.fragments.sub_category

import android.view.View
import androidx.navigation.Navigation

class SubCategoryItemListener(private val title:String, private val catId:Long,  private val item:View): View.OnClickListener {

    override fun onClick(v: View) {
        val actionSubCategoryFragmentToProductsFragment = SubCategoryFragmentDirections.actionSubCategoryFragmentToProductsFragment(title, catId)
//        actionSubCategoryFragmentToProductsFragment.subCategoryId = pos
        Navigation.findNavController(item).navigate(actionSubCategoryFragmentToProductsFragment)
    }

}