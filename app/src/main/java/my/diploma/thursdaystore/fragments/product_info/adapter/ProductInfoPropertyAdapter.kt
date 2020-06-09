package my.diploma.thursdaystore.fragments.product_info.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.retrofit.dto.product.Property

class ProductInfoPropertyAdapter(private val list: List<Property>) :
    RecyclerView.Adapter<ProductInfoPropertyAdapter.ProductInfoPropertyViewHolder>() {

    class ProductInfoPropertyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val key: TextView = itemView.findViewById(R.id.item_product_info_characteristics_key)
        val value: TextView = itemView.findViewById(R.id.item_product_info_characteristics_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductInfoPropertyViewHolder =
        ProductInfoPropertyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product_info_characteristics, parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ProductInfoPropertyViewHolder, position: Int) {
        val element = list[position]
        holder.key.text = element.propertyName
        holder.value.text = element.parameters[0].parameterName
    }

}