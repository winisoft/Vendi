package steve.sample.vendi.machine.stock

import androidx.annotation.DrawableRes
import steve.sample.vendi.R

sealed class Product(open val price: Float, val name: String, @DrawableRes val image: Int) {

    object Cola: Product(1.0f, "Cola", R.drawable.cola)

    object Chips: Product(0.5f, "Chips", R.drawable.chips)

    object Candy: Product(0.65f, "Candy", R.drawable.candy)
}