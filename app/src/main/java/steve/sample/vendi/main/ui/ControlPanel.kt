package steve.sample.vendi.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import steve.sample.vendi.R
import steve.sample.vendi.machine.led.LedDisplay
import steve.sample.vendi.machine.stock.Product

class ControlPanel(val balance: StateFlow<Float>) {

    @Composable
    fun ControlPanelInterface() {
        Column(Modifier.background(Color.Black)) {
            LedDisplay(0.0f, 100.dp, 40.dp)
            CtrlPanelBtn(Product.Cola)
            CtrlPanelBtn(Product.Chips)
            CtrlPanelBtn(Product.Candy)
        }
    }

    @Composable
    fun CtrlPanelBtn(product: Product) {
        OutlinedButton(onClick = {

        }, modifier = Modifier
            .padding(.5.dp)
            .background(color = colorResource(id = R.color.ctrl_panel_btn_default))
        ) {
            Text(text = product.name,
                color = colorResource(id = R.color.ctrl_panel_text)
             )
        }
    }

}

@Preview
@Composable
fun PreviewControlPanel() {
    val _state = MutableStateFlow<Float>(0.0f)
    val state: StateFlow<Float> = _state
    ControlPanel(state)
        .ControlPanelInterface()
}