package my.diploma.thursdaystore.product_adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

abstract class AbstractProductsAdapter(private val list: List<ProductResponse>) :
    RecyclerView.Adapter<AbstractProductsAdapter.ProductsViewHolder>() {

    class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val container: View = itemView.findViewById(R.id.productItemContainer)
        val image: ImageView = itemView.findViewById(R.id.productItemImage)
        val title: TextView = itemView.findViewById(R.id.productItemTitle)
        val price: TextView = itemView.findViewById(R.id.productItemPrice)
        val star: ImageView = itemView.findViewById(R.id.productItemImageStar)
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

        Glide.with(holder.itemView)
            .load(if (element.images.isEmpty()) null else element.images[0])
            .error(R.drawable.category_back_2)
            .into(holder.image)

        holder.title.text = element.name ?: "null"
        holder.price.text = element.price

        holder.container.setOnClickListener(
            getProductClickListener(position.toLong(), holder.itemView)
        )

    }

    abstract fun getProductClickListener(position:Long, view:View): View.OnClickListener

}