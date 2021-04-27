package steve.sample.vendi.machine.acceptor.bank

import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

interface BalanceCoinBank {

    val balance: StateFlow<Float>

    fun addQuarter()

    fun addDime()

    fun addNickel()

    fun purchase(price: Float)

    fun refundCurrentBalance()
}