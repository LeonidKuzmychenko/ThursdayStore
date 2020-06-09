package my.diploma.thursdaystore.product_adapter.listeners

import android.view.View

class ProductItemClickListener(private val pos:Long, private val item:View): View.OnClickListener{

    override fun onClick(v: View) {
//        val actionProductsFragmentToProductTreeFragment =
//            ProductsFragmentDirections.actionProductsFragmentToProductTreeFragment()
//        actionProductsFragmentToProductTreeFragment.productId = pos
//        Navigation.findNavController(item).navigate(actionProductsFragmentToProductTreeFragment)
    }

}