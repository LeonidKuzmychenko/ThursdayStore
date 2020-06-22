package my.diploma.thursdaystore.product_adapter.listeners

import android.view.View
import my.diploma.thursdaystore.custom_view.CartImageView
import my.diploma.thursdaystore.drawer.basket.BasketFragment
import my.diploma.thursdaystore.repository.WebRepositoryActions

class ProductCartClickListener: View.OnClickListener{

    private var f: BasketFragment? = null
    private var productId: Long = 0

    constructor(f: BasketFragment?, productId: Long){
        this.f = f
        this.productId = productId
    }

    constructor(productId: Long){
        this.productId = productId
    }


    override fun onClick(it: View) {
        if (it is CartImageView){
            if (it.getState()){
                it.setState(false)
                WebRepositoryActions.INSTANCE.deleteCart(productId)
                f?.listReview()
            }
            else{
                it.setState(true)
                WebRepositoryActions.INSTANCE.addCart(productId)
            }
        }
    }

}