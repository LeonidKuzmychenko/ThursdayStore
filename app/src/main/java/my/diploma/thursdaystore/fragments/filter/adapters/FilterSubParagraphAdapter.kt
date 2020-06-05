package my.diploma.thursdaystore.fragments.filter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.fragments.filter.FilterViewModel
import my.diploma.thursdaystore.retrofit.dto.filter.response.FilterParameter


class FilterSubParagraphAdapter(
    private val propertyId: Long,
    private val list: List<FilterParameter>,
    private val viewModel: FilterViewModel
) :
    RecyclerView.Adapter<FilterSubParagraphAdapter.FilterSubParagraphViewHolder>() {

    class FilterSubParagraphViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.item_filter_subparagraph_title)
        val container: View = itemView.findViewById(R.id.item_filter_subparagraph_container)
        val checkBox: CheckBox = itemView.findViewById(R.id.item_filter_subparagraph_check_box)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilterSubParagraphViewHolder =
        FilterSubParagraphViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_filter_subparagraph, parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FilterSubParagraphViewHolder, position: Int) {
        val element = list[position]

        val index = getIndexOfProperty(propertyId)
        val state = viewModel.liveDataFilterItem.value!!.filters[index].parameters.contains(element.parameterId)
        holder.checkBox.isChecked = state

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            val newValue = viewModel.liveDataFilterItem.value
            val parameters = newValue!!.filters[index].parameters
            val contains = parameters.contains(element.parameterId)

            if (isChecked && !contains) {
                parameters.add(element.parameterId)
            } else if (!isChecked && contains) {
                parameters.remove(element.parameterId)
            }
            viewModel.liveDataFilterItem.value = newValue
        }
        holder.title.text = element.parameterName
    }

    private fun getIndexOfProperty(propertyId: Long): Int {
        val properties = viewModel.liveDataFilterItem.value!!.filters
        val property = properties.filter { it.propertyId == propertyId }[0]
        return properties.indexOf(property)
    }

}