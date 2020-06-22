package my.diploma.thursdaystore.fragments.products.observers

import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.fragments.products.ProductsFragment
import my.diploma.thursdaystore.fragments.products.adapter.ProductsAdapter
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class ProductsLiveDataObserver(private val f: ProductsFragment,
                               private val rv: RecyclerView,
                               private val image: ImageView,
                               private val actionsContainer: View
) : Observer<List<ProductResponse>> {

    override fun onChanged(it: List<ProductResponse>) {
        Log.d("ProductsAdapterData","Filtered data = $it")

        image.visibility = if (it.isEmpty()) VISIBLE else GONE
        actionsContainer.visibility = if (it.isEmpty()) GONE else VISIBLE
        rv.adapter = ProductsAdapter(it)
    }
}