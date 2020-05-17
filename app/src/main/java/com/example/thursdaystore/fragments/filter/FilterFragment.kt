package com.example.thursdaystore.fragments.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.thursdaystore.R
import com.example.thursdaystore.fragments.products.ProductsFragmentArgs
import kotlinx.android.synthetic.main.filter_fragment.*
import kotlin.properties.Delegates

class FilterFragment : Fragment() {

    private lateinit var viewModel: FilterViewModel
    private var id by Delegates.notNull<Long>()
    private lateinit var title: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.filter_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let { init(it) } ?: run {
            Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
        }

        filterBtOk.setOnClickListener {
            val actionFilterFragmentToProductsFragment = FilterFragmentDirections.actionFilterFragmentToProductsFragment("$title filtered", id)
            Navigation.findNavController(it).navigate(actionFilterFragmentToProductsFragment)
        }

        viewModel = ViewModelProvider(this).get(FilterViewModel::class.java)
    }

    private fun init(bundle: Bundle) {
        id = ProductsFragmentArgs.fromBundle(bundle).subcategoryId
        title = ProductsFragmentArgs.fromBundle(bundle).title
    }

}
