package my.diploma.thursdaystore.drawer.category

import android.view.View
import androidx.navigation.Navigation

class CategoryItemListener(private val title:String, private val catId:Long,  private val item:View): View.OnClickListener {

    override fun onClick(v: View) {
        val actionNavCategoryToSubCategoryFragment = CategoryFragmentDirections.actionNavCategoryToSubCategoryFragment(title, catId)
//        actionNavCategoryToSubCategoryFragment.title = title
        Navigation.findNavController(item).navigate(actionNavCategoryToSubCategoryFragment)
    }

}