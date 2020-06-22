package my.diploma.thursdaystore.fragments.products

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.fragment_products.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.fragments.products.adapter.ProductsAdapter
import my.diploma.thursdaystore.fragments.products.dialogs.ChoiceSortDialog
import my.diploma.thursdaystore.fragments.products.listers.FilterButtonClickListener
import my.diploma.thursdaystore.fragments.products.observers.ProductsLiveDataObserver
import my.diploma.thursdaystore.repository.WebRepositoryActions
import my.diploma.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest


class ProductsFragment : Fragment() {

    lateinit var productsViewModel: ProductsViewModel
    private var filterItem: ApplyFilterItemRequest? = null
    private var stateSort = 0

    private lateinit var skeleton:RecyclerViewSkeletonScreen

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startSkeleton()

        filterItem = getBundleFilterItem()

        Log.d("FILTER_TEST", "Filter product = ${filterItem.toString()}")

        (activity as AppCompatActivity).supportActionBar?.let { it.title = getBundleTitle() }

        productsViewModel.listLiveData.observe(viewLifecycleOwner,
            ProductsLiveDataObserver(this, productsRecyclerView, productsEmptyBasket, productsActionsContainer)
        )

        productsFilter.setOnClickListener(FilterButtonClickListener(getBundleTitle(), getBundleId(), filterItem))

        if (filterItem != null) {
            Log.d("FILTER_TEST", "Show with filter")
            Log.d("FILTER_TEST", "Body = ${Moshi.Builder().build().adapter(ApplyFilterItemRequest::class.java).toJson(filterItem)}")
            WebRepositoryActions.INSTANCE.applyFilter(this, filterItem!!)
        }
        else {
            Log.d("FILTER_TEST", "Show without filter")
            WebRepositoryActions.INSTANCE.getProducts(this, getBundleId())
        }

        productsSort.setOnClickListener {
            val arraySort = arrayOf("по убыванию","по возрастанию")
            val btPositive = "Ok"
            val bundle = Bundle()

            bundle.putString(ChoiceSortDialog.DIALOG_SORT_TITLE_KEY,"Сортировка")
            bundle.putStringArray(ChoiceSortDialog.DIALOG_SORT_ITEMS_KEY, arrayOf(arraySort[0],arraySort[1]))
            bundle.putString(ChoiceSortDialog.DIALOG_SORT_BT_POSITIVE, btPositive)
            bundle.putInt(ChoiceSortDialog.DIALOG_SORT_STATE, this.stateSort)

            val dialog = ChoiceSortDialog()
            dialog.arguments = bundle
            dialog.show(childFragmentManager,"DIALOG SORT")
        }
    }

    fun getBundleId():Long {
        return ProductsFragmentArgs.fromBundle(requireArguments()).subcategoryId
    }

    fun getBundleTitle():String {
        return ProductsFragmentArgs.fromBundle(requireArguments()).title
    }

    fun getBundleFilterItem():ApplyFilterItemRequest? {
        return arguments?.let{ return ProductsFragmentArgs.fromBundle(it).filterRequest }
    }

    fun startSkeleton(){
        skeleton = Skeleton.bind(productsRecyclerView).adapter(ProductsAdapter(listOf())).load(R.layout.fragment_products_list_skeleton).show()
    }

    fun stopSkeleton(){
        skeleton.hide()
    }

    fun activateSort(typeSort: Int){
        stateSort = typeSort
        val arraySort = arrayOf("по убыванию","по возрастанию")
        productsSortTextState.text = arraySort[typeSort]

        when(typeSort){
            0 ->{
                val list = productsViewModel.listLiveData.value
                list?.sortByDescending { it.price }
                productsViewModel.listLiveData.value = list
            }
            1 ->{
                val list = productsViewModel.listLiveData.value
                list?.sortBy { it.price }
                productsViewModel.listLiveData.value = list
            }
            else -> { }
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
