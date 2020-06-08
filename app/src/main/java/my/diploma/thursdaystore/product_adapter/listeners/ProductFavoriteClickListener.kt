package my.diploma.thursdaystore.product_adapter.listeners

import android.view.View
import my.diploma.thursdaystore.custom_view.FavoriteImageView
import my.diploma.thursdaystore.repository.WebRepositoryActions

class ProductFavoriteClickListener(private val productId: Long): View.OnClickListener{

    override fun onClick(it: View) {
        if (it is FavoriteImageView){
            if (it.getState()){
                it.setState(false)
                WebRepositoryActions.INSTANCE.deleteFavorites(productId)
            }
            else{
                it.setState(true)
                WebRepositoryActions.INSTANCE.addFavorites(productId)
            }
        }
    }

}