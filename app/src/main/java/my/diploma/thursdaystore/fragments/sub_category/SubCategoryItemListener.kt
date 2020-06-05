package my.diploma.thursdaystore.fragments.sub_category

import android.view.View
import androidx.navigation.Navigation
import my.diploma.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest

class SubCategoryItemListener(private val title:String, private val catId:Long, private val item:View, private val filterItem: ApplyFilterItemRequest?): View.OnClickListener {

    override fun onClick(v: View) {
        val action = SubCategoryFragmentDirections.actionSubCategoryFragmentToProductsFragment(title, catId, filterItem)
        Navigation.findNavController(item).navigate(action)
    }

}