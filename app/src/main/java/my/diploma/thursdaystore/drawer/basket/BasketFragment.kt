package my.diploma.thursdaystore.drawer.basket

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import kotlinx.android.synthetic.main.fragment_basket.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.drawer.favorites.adapter.BasketAdapter
import my.diploma.thursdaystore.fragments.products.observers.BasketLiveDataObserver
import my.diploma.thursdaystore.repository.WebRepositoryActions
import my.diploma.thursdaystore.utils.Lines

class BasketFragment : Fragment() {

    lateinit var basketViewModel: BasketViewModel
    private lateinit var skeleton: RecyclerViewSkeletonScreen

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startSkeleton()

        (activity as AppCompatActivity).supportActionBar?.let {
            it.title = Lines.get(R.string.fragment_cart_title)
        }

        basketRecyclerView.layoutManager = GridLayoutManager(context, 2)

        basketViewModel.listLiveData.observe(viewLifecycleOwner, BasketLiveDataObserver(basketRecyclerView))

        WebRepositoryActions.INSTANCE.getCart(this)
    }

    fun startSkeleton(){
        skeleton = Skeleton.bind(basketRecyclerView).adapter(BasketAdapter(listOf())).load(R.layout.fragment_products_list_skeleton).show()
    }

    fun stopSkeleton(){
        skeleton.hide()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        basketViewModel = ViewModelProvider(this).get(BasketViewModel::class.java)
        return inflater.inflate(R.layout.fragment_basket, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_basket_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.make_purchases) {
            val action = BasketFragmentDirections.actionNavBasketToMakePurchaseFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }
}