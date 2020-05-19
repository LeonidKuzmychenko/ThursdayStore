package com.example.thursdaystore.fragments.filter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.R
import com.example.thursdaystore.retrofit.dto.filter.FilterParameter


class FilterSubParagraphAdapter(private val list: List<FilterParameter>) :
    RecyclerView.Adapter<FilterSubParagraphAdapter.FilterSubParagraphViewHolder>() {

    class FilterSubParagraphViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.item_filter_subparagraph_title)
        val container: View = itemView.findViewById(R.id.item_filter_subparagraph_container)
        val checkBox: View = itemView.findViewById(R.id.item_filter_subparagraph_check_box)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterSubParagraphViewHolder =
        FilterSubParagraphViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_filter_subparagraph, parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FilterSubParagraphViewHolder, position: Int) {
        val element = list[position]
        holder.title.text = element.parameterName
    }

}