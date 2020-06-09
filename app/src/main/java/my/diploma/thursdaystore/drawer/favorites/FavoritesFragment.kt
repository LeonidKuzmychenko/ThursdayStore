package my.diploma.thursdaystore.drawer.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_favorites.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.fragments.products.observers.FavoritesLiveDataObserver
import my.diploma.thursdaystore.repository.WebRepositoryActions
import my.diploma.thursdaystore.utils.Lines

class FavoritesFragment : Fragment() {

    private lateinit var favoritesViewModel: FavoritesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.let {
            it.title = Lines.get(R.string.fragment_favorites_title)
        }

        favoritesRecyclerView.layoutManager = GridLayoutManager(context ,2)

        favoritesViewModel.liveData.observe(viewLifecycleOwner, FavoritesLiveDataObserver(favoritesRecyclerView))

        WebRepositoryActions.INSTANCE.getFavorites(favoritesViewModel.liveData)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        favoritesViewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }
}