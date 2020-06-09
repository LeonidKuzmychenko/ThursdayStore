package my.diploma.thursdaystore.fragments.product_tree

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import my.diploma.thursdaystore.R


class ProductTreeFragment : Fragment() {

    private lateinit var productTreeViewModel: ProductTreeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { init(it) } ?: run {
            Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        productTreeViewModel = ViewModelProvider(this).get(ProductTreeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_product_info, container, false)
    }

    private fun init(bundle: Bundle) {
        (activity as AppCompatActivity).supportActionBar?.let {
//            it.title = "${it.title}: ${ProductTreeFragmentArgs.fromBundle(bundle).productId}"
        }
    }
}
