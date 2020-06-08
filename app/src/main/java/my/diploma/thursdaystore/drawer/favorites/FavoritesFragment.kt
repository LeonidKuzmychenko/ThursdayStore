package my.diploma.thursdaystore.drawer.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_favorites.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.fragments.products.observers.ProductsLiveDataObserver
import my.diploma.thursdaystore.repository.WebRepositoryActions

class FavoritesFragment : Fragment() {

    private lateinit var favoritesViewModel: FavoritesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoritesRecyclerView.layoutManager = GridLayoutManager(context ,2)

        favoritesViewModel.liveData.observe(viewLifecycleOwner, ProductsLiveDataObserver(favoritesRecyclerView))

//        favoritesViewModel.listLiveData.value = mutableListOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)

        WebRepositoryActions.INSTANCE.getFavorites(favoritesViewModel.liveData)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        favoritesViewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }
}