package steve.sample.vendi.machine.acceptor.bank

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import steve.sample.vendi.machine.change.CoinReturn
import steve.sample.vendi.money.TheoreticalCoin
import steve.sample.vendi.money.MaybeCoinObject
import java.lang.IllegalArgumentException
import javax.inject.Inject

class BalanceCoinBankImpl
@Inject
constructor() : BalanceCoinBank {

    private val _balance = MutableStateFlow(0f)
    override val balance: StateFlow<Float> = _balance

    private var countNickels: Int = 0
    private var countDimes: Int = 0
    private var countQuarters: Int = 0

    override fun addQuarter() {
        countQuarters += 1
        _balance.value += TheoreticalCoin.Quarter.currencyValue
    }

    override fun addDime() {
        countDimes += 1
        _balance.value += TheoreticalCoin.Dime.currencyValue
    }

    override fun addNickel() {
        countNickels += 1
        _balance.value += TheoreticalCoin.Nickel.currencyValue
    }

    override fun purchase(price: Float) {
        if (balance.value < price)
            throw IllegalArgumentException("Attempted purchase with insufficient balance")

        var notYetTendered = price
        while(notYetTendered > 0f) {
            when {
                notYetTendered >= .25f && countQuarters > 0 -> {
                    _balance.value -= .25f
                    notYetTendered -= .25f
                    countQuarters -= 1
                }
                notYetTendered < .25f && balance.value >= .1f && countDimes > 0 -> {
                    _balance.value -= .1f
                    notYetTendered -= .1f
                    countDimes -= 1
                }
                else -> {
                    _balance.value -= .05f
                    notYetTendered -= .05f
                    countNickels -= 1
                }
            }
        }

        refundCurrentBalance()
    }

    override fun refundCurrentBalance() {
        repeat(countNickels) {
            returnObject(TheoreticalCoin.Nickel)
            countNickels -= 1
        }
        repeat(countDimes) {
            returnObject(TheoreticalCoin.Dime)
            countDimes -= 1
        }
        repeat(countQuarters) {
            returnObject(TheoreticalCoin.Quarter)
            countQuarters -= 1
        }
    }

    private fun returnObject(coin: TheoreticalCoin) {
        CoinReturn.add(object: MaybeCoinObject {
            override val weightMilligrams = coin.weightMilligrams
            override val lengthMicrometers = coin.diameterMicrometers * 2
            override val widestPointMicrometers = coin.thicknessMicrometers
            override val materialComposition: MaybeCoinObject.MaterialComposition =
                when (coin) {
                    is TheoreticalCoin.Quarter, TheoreticalCoin.Dime -> MaybeCoinObject.MaterialComposition.COPPER_92_NICKEL_8
                    is TheoreticalCoin.Nickel -> MaybeCoinObject.MaterialComposition.COPPER_75_NICKEL_25
                    else -> throw IllegalArgumentException("How is this not a dime, a quarter, or nickel")
                }
        })
        _balance.value -= coin.currencyValue
    }

}