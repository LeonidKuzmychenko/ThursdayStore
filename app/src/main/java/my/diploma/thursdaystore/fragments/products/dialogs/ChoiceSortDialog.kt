package my.diploma.thursdaystore.fragments.products.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import my.diploma.thursdaystore.fragments.products.ProductsFragment


class ChoiceSortDialog : AppCompatDialogFragment() {

    companion object {
        val DIALOG_SORT_TITLE_KEY = "DIALOG_SORT_TITLE_KEY"
        val DIALOG_SORT_ITEMS_KEY = "DIALOG_SORT_ITEMS_KEY"
        val DIALOG_SORT_BT_POSITIVE = "DIALOG_SORT_BT_POSITIVE"
        val DIALOG_SORT_STATE = "DIALOG_SORT_STATE"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        return arguments?.let {
            val title: String = it.getString(DIALOG_SORT_TITLE_KEY, "")
            val items = it.getStringArray(DIALOG_SORT_ITEMS_KEY)
            val btPositive = it.getString(DIALOG_SORT_BT_POSITIVE)
            val stateSort = it.getInt(DIALOG_SORT_STATE)


            var newState = stateSort

            builder.setTitle(title)
            builder.setSingleChoiceItems(items, stateSort) { _, which ->
//                Toast.makeText(requireContext(), items!![which], Toast.LENGTH_SHORT).show()
                newState = which
            }
            builder.setPositiveButton(btPositive) { dialog, id ->
//                Toast.makeText(requireContext(), "" + (parentFragment is ProductsFragment), Toast.LENGTH_SHORT).show()
                (parentFragment as ProductsFragment).activateSort(newState)
            }
            builder.create()
        } ?: super.onCreateDialog(savedInstanceState)
    }

}


