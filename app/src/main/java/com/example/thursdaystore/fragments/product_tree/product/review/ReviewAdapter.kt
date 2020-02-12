package com.example.thursdaystore.fragments.product_tree.product.review

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.R

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {


    class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    lateinit var list:MutableList<Int>

    constructor(list: MutableList<Int>) : super() {
        this.list = list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder =
        ReviewViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_review,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {}

}