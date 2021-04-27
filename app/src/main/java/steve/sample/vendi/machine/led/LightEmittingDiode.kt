package steve.sample.vendi.machine.led

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import steve.sample.vendi.R
import steve.sample.vendi.ui.theme.LedActivated
import steve.sample.vendi.ui.theme.LedInactive

sealed class LightEmittingDiode(@DrawableRes val drawable: Int, private val primesMask: Long) {

    object BottomLeft:      LightEmittingDiode(R.drawable.ic_diode_bottom_left, 3910)
    object Bottom:          LightEmittingDiode(R.drawable.ic_diode_bottom, 355810)
    object BottomRight:     LightEmittingDiode(R.drawable.ic_diode_bottom_right, 1293938646)
    object Middle:          LightEmittingDiode(R.drawable.ic_diode_middle, 56751695)
    object TopLeft:         LightEmittingDiode(R.drawable.ic_diode_top_left, 3242954)
    object Top:             LightEmittingDiode(R.drawable.ic_diode_top, 11532430)
    object TopRight:        LightEmittingDiode(R.drawable.ic_diode_top_right, 29274630)
    
    fun getColor(numeral: Char?): Color = numeral
        .also { require(it != null && it.toByte() in 48..57) }
        .let { (primesMask % arrayOf(2,3,5,7,11,13,17,19,23,29)[it!!.toByte() - 48]) == 0L }
        .run { if (this) LedActivated else LedInactive }
}

@Composable
fun LedDisplay(price: Float, width: Dp, height: Dp) {
    val chars: CharArray = price.toString().filterNot { it == '.' }.toCharArray()
    Row {
        LedNumeral(chars[0], width * .3f, height)
        LedDecimal(width = width * .1f, height = height)
        LedNumeral(chars[1], width * .3f, height)
        LedNumeral(chars[2], width * .3f, height)
    }
}

@Composable
fun LedDecimal(width: Dp, height: Dp) {
    Column {
        Spacer(Modifier.height(height - width))
        Canvas(modifier = Modifier
            .size(width = width, height = height),
            onDraw = {
                drawCircle(color = Color.Red)
            }
        )
    }

}

@Composable
fun LedNumeral(numeral: Char, width: Dp, height: Dp) {
    Box {
        listOf(
            LightEmittingDiode.BottomLeft,
            LightEmittingDiode.Bottom,
            LightEmittingDiode.BottomRight,
            LightEmittingDiode.Middle,
            LightEmittingDiode.TopLeft,
            LightEmittingDiode.Top,
            LightEmittingDiode.TopRight
        ).map {
            Image(
                modifier = Modifier
                    .size(width = width, height = height)
                    .background(color = Color.Transparent)
                    .padding(horizontal = 4.dp, vertical = 0.dp),
                painter = painterResource(it.drawable),
                contentDescription = null,
                colorFilter = ColorFilter.tint(it.getColor(numeral))
            )
        }
    }
}