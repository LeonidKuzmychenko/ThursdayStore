package com.example.thursdaystore.fragments.sub_category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.R

class SubCategoryAdapter(private val list: MutableList<Int>) :
    RecyclerView.Adapter<SubCategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val text: TextView = itemView.findViewById(R.id.categoryItemText)
        val container: View = itemView.findViewById(R.id.categoryItemContainer)
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
        holder.container.setOnClickListener {
            val actionSubCategoryFragmentToProductsFragment = SubCategoryFragmentDirections.actionSubCategoryFragmentToProductsFragment()
            actionSubCategoryFragmentToProductsFragment.subCategoryId = position.toLong()
            Navigation.findNavController(holder.itemView).navigate(actionSubCategoryFragmentToProductsFragment)
        }
    }

}