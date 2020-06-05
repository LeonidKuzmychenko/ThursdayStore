package my.diploma.thursdaystore.fragments.product_tree.product.specifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.R

class SpecificationsAdapter(private val list: MutableList<Int>) :
    RecyclerView.Adapter<SpecificationsAdapter.SpecificationsViewHolder>() {

    class SpecificationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecificationsViewHolder =
        SpecificationsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_specific,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SpecificationsViewHolder, position: Int) {}

}