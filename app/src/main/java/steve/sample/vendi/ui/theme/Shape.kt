package steve.sample.vendi.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

@Composable
fun DrawScope.IsoscelesTrapezoid() {
    val localContext = LocalContext.current
    val density = Density(localContext).density

    Canvas(modifier = Modifier.size(800.dp, 30.dp), onDraw = {
            drawPath(path = Path().apply {
                    lineTo(800.0f * density, 0f)
                    lineTo(770.0f * density, -30.0f * density)
                    lineTo(30.0f * density, -30.0f * density)
                    lineTo(0f, 0f)
                    close()
                }, color = Color.DarkGray
            )
        }
    )
}