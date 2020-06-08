package my.diploma.thursdaystore.fragments.products

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.fragment_products.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.fragments.products.dialogs.ChoiceSortDialog
import my.diploma.thursdaystore.fragments.products.listers.FilterButtonClickListener
import my.diploma.thursdaystore.fragments.products.observers.ProductsLiveDataObserver
import my.diploma.thursdaystore.repository.WebRepositoryActions
import my.diploma.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest


class ProductsFragment : Fragment() {

    private lateinit var productsViewModel: ProductsViewModel
    private var filterItem: ApplyFilterItemRequest? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id: Long
        val title: String
        arguments.let {
            id = ProductsFragmentArgs.fromBundle(it!!).subcategoryId
            title = ProductsFragmentArgs.fromBundle(it).title
            filterItem = ProductsFragmentArgs.fromBundle(it).filterRequest
        }

        Log.d("FILTER_TEST", "Filter product = ${filterItem.toString()}")

        (activity as AppCompatActivity).supportActionBar?.let { it.title = title }

        productsViewModel.listLiveData.observe(viewLifecycleOwner,
            ProductsLiveDataObserver(productsRecyclerView)
        )

        productsFilter.setOnClickListener(FilterButtonClickListener(title, id, filterItem))

        if (filterItem != null) {
            Log.d("FILTER_TEST", "Show with filter")
            Log.d("FILTER_TEST", "Body = ${Moshi.Builder().build().adapter(ApplyFilterItemRequest::class.java).toJson(filterItem)}")
            WebRepositoryActions.INSTANCE.applyFilter(filterItem!!, productsViewModel.listLiveData)
        }
        else {
            Log.d("FILTER_TEST", "Show without filter")
            WebRepositoryActions.INSTANCE.getProducts(id, productsViewModel.listLiveData)
        }

        productsSort.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(ChoiceSortDialog.DIALOG_SORT_TITLE_KEY,"Сортировка")
            bundle.putStringArray(ChoiceSortDialog.DIALOG_SORT_ITEMS_KEY, arrayOf("по рейтингу","по убыванию","по возрастанию"))

            val dialog = ChoiceSortDialog()
            dialog.arguments = bundle
            dialog.show(childFragmentManager,"DIALOG SORT")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productsViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

}
