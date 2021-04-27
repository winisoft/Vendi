package steve.sample.vendi.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.StateFlow
import steve.sample.vendi.R
import steve.sample.vendi.machine.VendingMachine
import steve.sample.vendi.machine.stock.Product
import steve.sample.vendi.money.MaybeCoinObject
import steve.sample.vendi.ui.theme.VendiTheme
import steve.sample.vendi.user.Pockets

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VendiTheme {
                VendingMachine(
                    viewModel = viewModel,
                    display = viewModel.vendingMachine.display,
                    stock = viewModel.vendingMachine.productStock.items,
                    coinBank = viewModel.vendingMachine.coinBank.balance
                )
            }
        }
    }
}

@ExperimentalStdlibApi
@Composable
fun VendingMachine(
    viewModel: MainViewModel,
    display: StateFlow<String>,
    stock: StateFlow<List<Product>>,
    coinBank: StateFlow<Float>
) {
    Row {

        Box() {

            Image(
                modifier = Modifier,
                painter = painterResource(R.drawable.vending_machine),
                contentDescription = null
            )

            Text(
                modifier = Modifier
                    .size(width = 250.dp, height = 100.dp)
                    .offset(x = 182.0.dp, y = 94.0.dp),
                text = display.collectAsState(viewModel.viewModelScope.coroutineContext).value,
                color = Color.Red,
                fontSize = 26.sp
            )

            Column(Modifier.offset(x = 200.dp, y = 180.dp)) {

                ProductItem(
                    Product.Cola,
                    viewModel.onProductClicked(Product.Cola)
                )

                ProductItem(
                    Product.Chips,
                    viewModel.onProductClicked(Product.Chips)
                )

                ProductItem(
                    Product.Candy,
                    viewModel.onProductClicked(Product.Candy)
                )
            }
        }

        Column {
            InsertButton(Pockets.quarter, "quarter", viewModel.vendingMachine)
            InsertButton(Pockets.dime, "dime", viewModel.vendingMachine)
            InsertButton(Pockets.nickel, "nickel", viewModel.vendingMachine)
            InsertButton(Pockets.penny, "penny", viewModel.vendingMachine)
            InsertButton(Pockets.button, "loose button", viewModel.vendingMachine)
            InsertButton(Pockets.woodenNickel, "wooden nickel", viewModel.vendingMachine)
            TextButton(
                onClick = { viewModel.vendingMachine.refund() },
                Modifier
                    .background(color = Color.Green)
                    .border(width = 2.dp, Color.Black)
                    .size(width = 250.dp, height = 100.dp)
            ) {
                Text(
                    "Press coin return",
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }
        }
    }

}

@Composable
fun ProductItem(item: Product, onClick: () -> Unit) {
    Column {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(100.dp)
        ) {
            Image(
                modifier = Modifier,
                painter = painterResource(item.image),
                contentDescription = null
            )
        }
        //LedDisplay(price = items.first().price, width = 40.dp, height = 20.dp)
    }
}

@Composable
fun InsertButton(maybeCoinObject: MaybeCoinObject, objectName: String, vendingMachine: VendingMachine) {
    TextButton(
        onClick = { vendingMachine.insert(maybeCoinObject) },
        Modifier
            .background(color = Color.Green)
            .border(width = 2.dp, Color.Black)
            .size(width = 250.dp, height = 100.dp)
    ) {
        Text(
            "Insert a $objectName",
            color = Color.Black,
            fontSize = 20.sp
        )
    }
}