package com.example.thursdaystore.drawer.category

import android.view.View
import androidx.navigation.Navigation

class CategoryItemListener(private val title:String, private val item:View): View.OnClickListener {

    override fun onClick(v: View) {
        val actionNavCategoryToSubCategoryFragment = CategoryFragmentDirections.actionNavCategoryToSubCategoryFragment(title)
//        actionNavCategoryToSubCategoryFragment.title = title
        Navigation.findNavController(item).navigate(actionNavCategoryToSubCategoryFragment)
    }

}