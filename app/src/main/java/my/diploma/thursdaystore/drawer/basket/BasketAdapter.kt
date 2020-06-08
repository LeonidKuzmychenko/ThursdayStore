package my.diploma.thursdaystore.drawer.basket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class BasketAdapter(private val list: List<ProductResponse>) :
    RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {

    class BasketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder =
        BasketViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_basket,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {}

}