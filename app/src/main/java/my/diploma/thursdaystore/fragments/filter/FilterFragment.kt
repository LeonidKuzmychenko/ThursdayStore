package my.diploma.thursdaystore.fragments.filter

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_filter.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.fragments.filter.observers.FilterUiObserver
import my.diploma.thursdaystore.fragments.filter.observers.SavedFilterObserver
import my.diploma.thursdaystore.fragments.products.ProductsFragmentArgs
import my.diploma.thursdaystore.repository.WebRepositoryActions

class FilterFragment : Fragment() {

    lateinit var vm: FilterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)
        vm = ViewModelProvider(this).get(FilterViewModel::class.java)
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filterRecyclerView.isNestedScrollingEnabled = false //скрол рейсайклера вместе с ценой
        vm.savedFilter.observe(viewLifecycleOwner, SavedFilterObserver(this))

        arguments?.let {
            vm.savedFilter.value = getBundleFilter(it)
            vm.filterUi.observe(viewLifecycleOwner, FilterUiObserver(this, getBundleId(it)))
            WebRepositoryActions.INSTANCE.getFilter(getBundleId(it), vm.filterUi)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_filter_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.filter_ok) {
            arguments?.let { Navigation.findNavController(requireView()).navigate(getAction(it)) }
        }
        return super.onOptionsItemSelected(item)
    }

    fun setSeekBarMax(value: Int) {
        filterPriceSeekBar.max = value
    }

    fun setSeekBarProgress(value: Int) {
        filterPriceSeekBar.progress = value
    }

    fun setSeekBarText(value: String) {
        filterPriceMax.text = value
    }

    private fun getAction(bundle:Bundle) : FilterFragmentDirections.ActionFilterFragmentToProductsFragment {
        val id = getBundleId(bundle)
        val title = getBundleTitle(bundle)
        val filter = vm.savedFilter.value
        return FilterFragmentDirections.actionFilterFragmentToProductsFragment(title, id, filter)
    }

    private fun getBundleFilter(bundle:Bundle) = ProductsFragmentArgs.fromBundle(bundle).filterRequest

    private fun getBundleTitle(bundle:Bundle) = ProductsFragmentArgs.fromBundle(bundle).title

    private fun getBundleId(bundle:Bundle) = ProductsFragmentArgs.fromBundle(bundle).subcategoryId

}
