package my.diploma.thursdaystore.drawer.purchases

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.R

class PurchasesAdapter(private val list: MutableList<Int>) :
    RecyclerView.Adapter<PurchasesAdapter.PurchasesViewHolder>() {

    class PurchasesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchasesViewHolder =
        PurchasesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_purchase,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PurchasesViewHolder, position: Int) {}

}