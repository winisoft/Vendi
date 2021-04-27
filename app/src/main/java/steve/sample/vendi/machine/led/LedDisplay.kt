package steve.sample.vendi.machine.led

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.IllegalArgumentException
import kotlin.random.Random

class LedDisplay(val scope: CoroutineScope, val currentBalance: StateFlow<Float>) {

    @Composable
    fun CollectingCompose() {
        Row(modifier = Modifier
            .background(Color.Black)
            .size(width = 180.dp, height = 60.dp)
        ) {
            currentBalance.collectAsState(scope.coroutineContext)
                .value.toChars()
                .forEach {

                }
        }
    }

    private fun Float.toChars(): CharArray {
        if (this < 0 || this > 9.99f)
            throw IllegalArgumentException()
        return if (this < 1.00)
            toString().takeLast(2).toCharArray()
        else
            toString().toCharArray()
    }
}

@Preview
@Composable
private fun PreviewLedDisplay() {
    val scope = CoroutineScope(Dispatchers.Default + Job())
    val _stateFlow = MutableStateFlow(2.35f)
    val stateFlow = _stateFlow
    LaunchedEffect(scope) {
        repeat(30) {
            delay(500)
            stateFlow.emit((Random.nextFloat() * 1000).toString()
                .let { "${it[0]}${it.substring(1)}" }.toFloat())
        }
    }

    LedDisplay(scope, stateFlow).CollectingCompose()
}