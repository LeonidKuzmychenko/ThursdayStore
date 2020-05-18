package com.example.thursdaystore.fragments.filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.R
import com.example.thursdaystore.retrofit.dto.filter.FilterResponse


class FilterParagraphAdapter(private val list: List<FilterResponse>) :
    RecyclerView.Adapter<FilterParagraphAdapter.FilterParagraphViewHolder>() {

    class FilterParagraphViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.item_filter_paragraph_title)
        val container: View = itemView.findViewById(R.id.item_filter_paragraph_container)
        val image: ImageView = itemView.findViewById(R.id.item_filter_paragraph_image)
        val recyclerView: RecyclerView =
            itemView.findViewById(R.id.item_filter_paragraph_recycler_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterParagraphViewHolder =
        FilterParagraphViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_filter_paragraph, parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FilterParagraphViewHolder, position: Int) {
        val element = list[position]
        holder.title.text = element.propertyName
        holder.recyclerView.adapter = FilterSubParagraphAdapter(element.filterParameters)

        holder.image.setOnClickListener {
            val rc = holder.recyclerView
            rc.visibility = if (rc.isVisible) View.GONE else View.VISIBLE
        }
    }

}