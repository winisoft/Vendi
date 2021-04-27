package steve.sample.vendi

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import steve.sample.vendi.money.MaybeCoinObject

class CoinReturnViewModel: ViewModel() {

    val itemsPresent: MutableList<MaybeCoinObject> = mutableListOf()
}

class CoinReturnFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

            }
        }
    }
}

@Composable
fun CoinReturn() {
    Canvas(modifier = Modifier.size(50.dp),
        onDraw = {
            val size = 50.dp.toPx()
            drawCircle(
                color = Color.LightGray,
                radius = size / 2f
            )
            Path().apply {
                // Moves to top center position
                moveTo(size / 2f, 0f)
                // Add line to bottom right corner
                lineTo(size, size)
                // Add line to bottom left corner
                lineTo(0f, size)

                drawPath(color = Color.Green, path = this)
            }
    })
}

@Preview
@Composable
fun PreviewCoinReturn() {
    CoinReturn()
}