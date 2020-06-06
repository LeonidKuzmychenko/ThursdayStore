package my.diploma.thursdaystore.fragments.products.dialogs

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment


class ChoiceSortDialog : AppCompatDialogFragment() {

    companion object{
        val DIALOG_SORT_TITLE_KEY = "DIALOG_SORT_TITLE_KEY"
        val DIALOG_SORT_ITEMS_KEY = "DIALOG_SORT_ITEMS_KEY"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        return arguments?.let {
            val title: String = it.getString(DIALOG_SORT_TITLE_KEY, "")
            val items = it.getStringArray(DIALOG_SORT_ITEMS_KEY)

            builder.setTitle(title)
            builder.setItems(items) { _, which ->
                Toast.makeText(requireContext(), "Значение = " + items!![which], Toast.LENGTH_SHORT).show()
            }
            builder.create()
        } ?: super.onCreateDialog(savedInstanceState)

    }

}


