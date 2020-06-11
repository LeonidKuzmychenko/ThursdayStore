package my.diploma.thursdaystore.drawer.purchases

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.drawer.purchases.dialogs.PurchaseInfoDialog
import my.diploma.thursdaystore.retrofit.dto.purchases.get.GetPurchasesResponse

class PurchasesAdapter(private val list: List<GetPurchasesResponse>, private val f:PurchasesFragment) :
    RecyclerView.Adapter<PurchasesAdapter.PurchasesViewHolder>() {

    class PurchasesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val id: TextView = itemView.findViewById(R.id.item_purchase_id)
        val price: TextView = itemView.findViewById(R.id.item_purchase_price)
        val status: TextView = itemView.findViewById(R.id.item_purchase_status)
        val statusDate: TextView = itemView.findViewById(R.id.item_purchase_status_date)
        val statusPrice: TextView = itemView.findViewById(R.id.item_purchase_status_price)
        val image1: ImageView = itemView.findViewById(R.id.item_purchase_image_1)
        val image2: ImageView = itemView.findViewById(R.id.item_purchase_image_2)
        val image3: ImageView = itemView.findViewById(R.id.item_purchase_image_3)
        val container: View = itemView.findViewById(R.id.item_purchase_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PurchasesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_purchase, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PurchasesViewHolder, position: Int) {
        val element = list[position]
        holder.id.text = element.id.toString()
        holder.status.text = element.status
        holder.statusDate.text = element.date

        holder.container.setOnClickListener {
            PurchaseInfoDialog().show(f.childFragmentManager, "PurchaseInfoDialog")
        }
    }

}