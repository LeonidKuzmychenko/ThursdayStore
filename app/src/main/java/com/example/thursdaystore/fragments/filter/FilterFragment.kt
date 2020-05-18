package com.example.thursdaystore.fragments.filter

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.thursdaystore.R
import com.example.thursdaystore.fragments.products.ProductsFragmentArgs


class FilterFragment : Fragment() {

    private lateinit var viewModel: FilterViewModel
    private lateinit var action: FilterFragmentDirections.ActionFilterFragmentToProductsFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            val id = ProductsFragmentArgs.fromBundle(it).subcategoryId
            val title = ProductsFragmentArgs.fromBundle(it).title

            action = FilterFragmentDirections.actionFilterFragmentToProductsFragment(title, id)

            viewModel = ViewModelProvider(this).get(FilterViewModel::class.java)
        } ?: run {
            Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_filter_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.filter_ok){
            this.view?.let {
                Navigation.findNavController(it).navigate(action)
            } ?: run {
                Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
