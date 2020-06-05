package my.diploma.thursdaystore.fragments.products.observers

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.fragments.products.adapter.ProductsAdapter
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class ProductsLiveDataObserver(private val rv: RecyclerView) : Observer<List<ProductResponse>> {

    override fun onChanged(it: List<ProductResponse>) {
        Log.d("ProductsAdapterData","Filtered data = $it")
        rv.adapter = ProductsAdapter(it)
    }
}