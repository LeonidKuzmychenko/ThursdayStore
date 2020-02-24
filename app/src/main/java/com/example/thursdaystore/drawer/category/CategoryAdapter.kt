package com.example.thursdaystore.drawer.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.R

class CategoryAdapter(private val list: MutableList<Int>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.categoryItemText)
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
        holder.text.text = position.toString()
        holder.text.setOnClickListener {
            val actionNavCategoryToSubCategoryFragment = CategoryFragmentDirections.actionNavCategoryToSubCategoryFragment()
            actionNavCategoryToSubCategoryFragment.categoryId = position.toLong()
            Navigation.findNavController(holder.itemView).navigate(actionNavCategoryToSubCategoryFragment)
        }

    }

}