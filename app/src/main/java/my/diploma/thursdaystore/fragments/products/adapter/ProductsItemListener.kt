package my.diploma.thursdaystore.fragments.products.adapter

import android.view.View
import androidx.navigation.Navigation
import my.diploma.thursdaystore.fragments.products.ProductsFragmentDirections

class ProductsItemListener(private val pos:Long, private val item:View): View.OnClickListener{

    override fun onClick(v: View) {
        val actionProductsFragmentToProductTreeFragment =
            ProductsFragmentDirections.actionProductsFragmentToProductTreeFragment()
        actionProductsFragmentToProductTreeFragment.productId = pos
        Navigation.findNavController(item).navigate(actionProductsFragmentToProductTreeFragment)
    }

}