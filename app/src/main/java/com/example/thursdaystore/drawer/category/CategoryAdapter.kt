package com.example.thursdaystore.drawer.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.R

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {


    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    lateinit var list:MutableList<Int>

    constructor(list: MutableList<Int>) : super() {
        this.list = list
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

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {}

}