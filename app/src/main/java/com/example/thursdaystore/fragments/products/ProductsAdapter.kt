package com.example.thursdaystore.fragments.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.R

class ProductsAdapter(private val list: MutableList<Int>) :
    RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val text: TextView = itemView.findViewById(R.id.productsItemText)
        val container: View = itemView.findViewById(R.id.productItemContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder =
        ProductsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.text.text = position.toString()
        holder.container.setOnClickListener(ProductsItemListener(position.toLong(), holder.itemView))
    }

}