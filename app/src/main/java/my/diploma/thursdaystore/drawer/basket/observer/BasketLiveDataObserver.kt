package my.diploma.thursdaystore.fragments.products.observers

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.drawer.favorites.adapter.BasketAdapter
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class BasketLiveDataObserver(private val rv: RecyclerView) : Observer<List<ProductResponse>> {

    override fun onChanged(it: List<ProductResponse>) {
        Log.d("ProductsAdapterData","Filtered data = $it")
        rv.adapter = BasketAdapter(it)
    }
}