package my.diploma.thursdaystore.fragments.filter

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_filter.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.fragments.filter.adapters.FilterParagraphAdapter
import my.diploma.thursdaystore.fragments.filter.listeners.PriceSeekBarChangeListener
import my.diploma.thursdaystore.fragments.products.ProductsFragmentArgs
import my.diploma.thursdaystore.repository.WebRepositoryActions
import my.diploma.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest
import my.diploma.thursdaystore.retrofit.dto.filter.request.FilterPricesRequest
import my.diploma.thursdaystore.retrofit.dto.filter.request.FilterPropertyRequest
import my.diploma.thursdaystore.utils.Language


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
        val filterItem: ApplyFilterItemRequest?
        arguments.let { bundle ->
            id = ProductsFragmentArgs.fromBundle(bundle!!).subcategoryId
            title = ProductsFragmentArgs.fromBundle(bundle).title
            filterItem = ProductsFragmentArgs.fromBundle(bundle).filterRequest
        }

        filterRecyclerView.isNestedScrollingEnabled = false //скрол рейсайклера вместе с ценой

        Log.d("FILTER_TEST", "Полученный фильтр с окна продуктов = $filterItem")

        viewModel.savedFilterState.observe(viewLifecycleOwner, Observer {//когда меняется этот фильтр, меняется экшн на запуск окна продуктов
            action = FilterFragmentDirections.actionFilterFragmentToProductsFragment(title, id, it)
        })
        viewModel.savedFilterState.value = filterItem

        viewModel.liveDataFilterUi.observe(viewLifecycleOwner, Observer {
            Log.d("FILTER_TEST", "viewModel.savedFilterState.value = " + viewModel.savedFilterState.value)
            Log.d("FILTER_TEST", "filterPriceSeekBar.max1 = " + filterPriceSeekBar.max)

            try {
                filterPriceSeekBar.max = it.filterPrices.max.toInt()
            }catch (e:Exception){
                filterPriceSeekBar.max = 10000
            }

            Log.d("FILTER_TEST", "filterPriceSeekBar.max2 = " + filterPriceSeekBar.max)

            if (viewModel.savedFilterState.value == null) {
                Log.d("FILTER_TEST", "viewModel.savedFilterState.value = null")
                val listOfFilterPropertyRequest: MutableList<FilterPropertyRequest> = mutableListOf()
                it.properties.forEach { listOfFilterPropertyRequest.add(FilterPropertyRequest(it.propertyId, mutableListOf())) }
                viewModel.savedFilterState.value = ApplyFilterItemRequest(id, Language.getLanguage(), FilterPricesRequest(1,it.filterPrices.max.toLong()), listOfFilterPropertyRequest)
            }

            Log.d("FILTER_TEST", "viewModel.savedFilterState.value = " + viewModel.savedFilterState.value)
            Log.d("FILTER_TEST", "viewModel.savedFilterState.value.filterPricesRequest.max = " +  viewModel.savedFilterState.value!!.filterPricesRequest.max)
            Log.d("FILTER_TEST", "filterPriceMax.text1 = " +  filterPriceMax.text)
            Log.d("FILTER_TEST", "filterPriceSeekBar.progress1 = " +  filterPriceSeekBar.progress)
            filterPriceMax.text = viewModel.savedFilterState.value!!.filterPricesRequest.max.toString()
            filterPriceSeekBar.progress = viewModel.savedFilterState.value!!.filterPricesRequest.max.toInt()
            Log.d("FILTER_TEST", "filterPriceMax.text2 = " +  filterPriceMax.text)
            Log.d("FILTER_TEST", "filterPriceSeekBar.progress2 = " +  filterPriceSeekBar.progress)

            filterPriceSeekBar.setOnSeekBarChangeListener(PriceSeekBarChangeListener(filterPriceMax, viewModel))

            filterRecyclerView.adapter = FilterParagraphAdapter(it.properties,viewModel)
        })

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
