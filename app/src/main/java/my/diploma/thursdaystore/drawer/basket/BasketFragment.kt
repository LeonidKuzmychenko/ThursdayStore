package my.diploma.thursdaystore.drawer.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_basket.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.fragments.products.observers.BasketLiveDataObserver
import my.diploma.thursdaystore.repository.WebRepositoryActions

class BasketFragment : Fragment() {

    private lateinit var basketViewModel: BasketViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        basketRecyclerView.layoutManager = GridLayoutManager(context, 2)

        basketViewModel.listLiveData.observe(viewLifecycleOwner, BasketLiveDataObserver(basketRecyclerView))

        WebRepositoryActions.INSTANCE.getCart(basketViewModel.listLiveData)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        basketViewModel = ViewModelProvider(this).get(BasketViewModel::class.java)
        return inflater.inflate(R.layout.fragment_basket, container, false)
    }
}