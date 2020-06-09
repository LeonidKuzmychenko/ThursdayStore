package my.diploma.thursdaystore.product_adapter.listeners

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

abstract class ProductItemClick: View.OnClickListener {

    final override fun onClick(v: View) {
        Navigation.findNavController(v).navigate(getAction())
    }

    abstract fun getAction(): NavDirections

}