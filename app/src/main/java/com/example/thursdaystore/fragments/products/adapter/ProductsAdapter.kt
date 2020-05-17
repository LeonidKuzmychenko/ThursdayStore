package com.example.thursdaystore.fragments.products.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thursdaystore.R
import com.example.thursdaystore.retrofit.dto.product.ProductResponse

class ProductsAdapter(private val list: List<ProductResponse>) :
    RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val container: View = itemView.findViewById(R.id.productItemContainer)
        val image: ImageView = itemView.findViewById(R.id.productItemImage)
        val title: TextView = itemView.findViewById(R.id.productItemTitle)
        val price: TextView = itemView.findViewById(R.id.productItemPrice)
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

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val element = list[position]
        Glide.with(holder.itemView).load(R.drawable.category_back_2).into(holder.image)
        holder.title.text = element.name ?: "null"
        holder.price.text = element.price.toString() + " \u20B4"
        holder.container.setOnClickListener(
            ProductsItemListener(
                position.toLong(),
                holder.itemView
            )
        )
    }

}