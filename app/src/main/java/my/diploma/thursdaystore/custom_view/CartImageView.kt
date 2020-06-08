package my.diploma.thursdaystore.custom_view

import android.content.Context
import android.util.AttributeSet
import com.bumptech.glide.Glide
import my.diploma.thursdaystore.R


class CartImageView : androidx.appcompat.widget.AppCompatImageView {

    private var state: Boolean = false

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setState(state: Boolean) {
        this.state = state

        val image =
            if (state) R.drawable.item_product_cart
            else R.drawable.item_product_cart_o

        Glide.with(this)
            .load(image)
            .into(this)
    }

    fun getState() = state


}