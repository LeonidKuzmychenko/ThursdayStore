package com.example.thursdaystore.drawer.category

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thursdaystore.R
import com.example.thursdaystore.retrofit.dto.category.CategoryResponse


class CategoryAdapter(private val list: List<CategoryResponse>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.categoryItemText)
        val container: View = itemView.findViewById(R.id.categoryItemContainer)
        val image: ImageView = itemView.findViewById(R.id.categoryItemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_category,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        val element = list[position]
        Log.d("TEST_VALUE", "name = ${element.name}")
        Log.d("TEST_VALUE", "id = ${element.id}")
        Log.d("TEST_VALUE", "image = ${element.image}")
        holder.text.text = element.name ?: "null"
        holder.container.setOnClickListener(CategoryItemListener(element.name ?: "null", element.id, holder.itemView))
        Glide.with(holder.itemView).load(R.drawable.category_back_2).into(holder.image)
    }

}