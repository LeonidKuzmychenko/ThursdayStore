package my.diploma.thursdaystore.fragments.products.observers

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.drawer.basket.BasketFragment
import my.diploma.thursdaystore.drawer.favorites.adapter.BasketAdapter
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class BasketLiveDataObserver(
    private val f: BasketFragment,
    private val rv: RecyclerView,
    private val image: ImageView
) : Observer<List<ProductResponse>> {

    override fun onChanged(it: List<ProductResponse>) {
        Log.d("ProductsAdapterData", "Filtered data = $it")

        if (it.isNotEmpty()) f.setHasOptionsMenu(true)
        image.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE

        rv.adapter = BasketAdapter(f,it)
    }
}