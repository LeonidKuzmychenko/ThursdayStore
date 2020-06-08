package my.diploma.thursdaystore.product_adapter.listeners

import android.view.View
import my.diploma.thursdaystore.custom_view.CartImageView
import my.diploma.thursdaystore.repository.WebRepositoryActions

class ProductCartClickListener(private val productId: Long): View.OnClickListener{

    override fun onClick(it: View) {
        if (it is CartImageView){
            if (it.getState()){
                it.setState(false)
                WebRepositoryActions.INSTANCE.deleteCart(productId)
            }
            else{
                it.setState(true)
                WebRepositoryActions.INSTANCE.addCart(productId)
            }
        }
    }

}