package my.diploma.thursdaystore.drawer.purchases.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment

class PurchaseInfoDialog: AppCompatDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Purchase Info")
            .setItems(arrayOf("info 1","info 2","info 3","info 4","info 5")){ dialog, which ->

            }
            .create()
    }
}