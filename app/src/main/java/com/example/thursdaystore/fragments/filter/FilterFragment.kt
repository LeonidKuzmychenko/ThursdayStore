package com.example.thursdaystore.fragments.filter

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.thursdaystore.R
import com.example.thursdaystore.fragments.filter.observers.FilterRequestObserver
import com.example.thursdaystore.fragments.filter.observers.FilterRequestObserverWithInit
import com.example.thursdaystore.fragments.products.ProductsFragmentArgs
import com.example.thursdaystore.repository.WebRepositoryActions
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterRequest
import kotlinx.android.synthetic.main.fragment_filter.*


class FilterFragment : Fragment() {

    private lateinit var viewModel: FilterViewModel
    private lateinit var action: FilterFragmentDirections.ActionFilterFragmentToProductsFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this).get(FilterViewModel::class.java)
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val id: Long
        val title: String
        val filter: ApplyFilterRequest?
        arguments.let { bundle ->
            id = ProductsFragmentArgs.fromBundle(bundle!!).subcategoryId
            title = ProductsFragmentArgs.fromBundle(bundle).title
            filter = ProductsFragmentArgs.fromBundle(bundle).filterRequest
        }

        filterRecyclerView.isNestedScrollingEnabled = false //скрол рейсайклера вместе с ценой

        Log.d("FILTER_TEST", "Полученный фильтр с окна продуктов = $filter")

        viewModel.liveDataFilter.observe(viewLifecycleOwner, Observer {//когда меняется этот фильтр, меняется экшн на запуск окна продуктов
            action = FilterFragmentDirections.actionFilterFragmentToProductsFragment(title, id, it)
        })

        if (filter == null)
            viewModel.liveDataFilterUi.observe(viewLifecycleOwner,
            FilterRequestObserverWithInit(
                filterRecyclerView,
                filterPriceSeekBar,
                filterPriceMax,
                viewModel,
                id)
        )
        else {
            viewModel.liveDataFilter.value = filter
            viewModel.liveDataFilterUi.observe(viewLifecycleOwner,
                FilterRequestObserver(
                    filterRecyclerView,
                    filterPriceSeekBar,
                    filterPriceMax,
                    viewModel)
            )
        }

        WebRepositoryActions.INSTANCE.getFilter(id, viewModel.liveDataFilterUi)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_filter_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.filter_ok) {
            this.view?.let {
                Navigation.findNavController(it).navigate(action)
            } ?: run {
                Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
