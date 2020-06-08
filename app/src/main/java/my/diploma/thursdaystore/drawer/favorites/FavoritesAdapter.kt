package my.diploma.thursdaystore.drawer.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class FavoritesAdapter(private val list: List<ProductResponse>) :
    RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder =
        FavoritesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_favorite,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {}

}