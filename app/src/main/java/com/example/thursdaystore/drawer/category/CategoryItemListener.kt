package com.example.thursdaystore.drawer.category

import android.view.View
import androidx.navigation.Navigation

class CategoryItemListener(private val pos:Long, private val item:View): View.OnClickListener {

    override fun onClick(v: View) {
        val actionNavCategoryToSubCategoryFragment = CategoryFragmentDirections.actionNavCategoryToSubCategoryFragment()
        actionNavCategoryToSubCategoryFragment.categoryId = pos
        Navigation.findNavController(item).navigate(actionNavCategoryToSubCategoryFragment)
    }

}