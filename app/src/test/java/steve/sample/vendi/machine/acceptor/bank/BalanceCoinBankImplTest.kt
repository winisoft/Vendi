package steve.sample.vendi.machine.acceptor.bank

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import steve.sample.vendi.machine.change.CoinReturn
import steve.sample.vendi.money.MaybeCoinObject
import steve.sample.vendi.money.TheoreticalCoin

internal class BalanceCoinBankImplTest {

    lateinit var sut: BalanceCoinBankImpl

    @Before
    fun prepare() {
        sut = BalanceCoinBankImpl()
    }

    @Nested
    @DisplayName("Given the need to properly maintain the user's current balance")
    inner class CurrentBalance {

        @Nested
        @DisplayName("When the coin bank is first created")
        inner class InitialState {

            @Test
            @DisplayName("Then the balance should be zero")
            fun test_initial_quarters_none() {
                assertEquals(0f, sut.balance.value)
            }
        }

        @Nested
        @DisplayName("When a coin is added, the balance should increase accordingly")
        inner class AddedCoins {

            @Test
            @DisplayName("Then adding a quarter should increase balance .25")
            fun test_addQuarter_balance_increasesBy25() {
                sut.addQuarter()
                assertEquals(.25f, sut.balance.value)
            }

            @Test
            @DisplayName("Then adding a dime should increase balance .1")
            fun test_addDime_balance_increasesBy10() {
                sut.addQuarter()
                assertEquals(.1f, sut.balance.value)
            }

            @Test
            @DisplayName("Then adding a nickel should increase balance .05")
            fun test_addNickel_balance_increasesBy5() {
                sut.addQuarter()
                assertEquals(.05f, sut.balance.value)
            }
        }

        @Nested
        @DisplayName("When a purchase is conducted")
        inner class Purchases {

            @Test
            @DisplayName("Then an exception is thrown if the balance is insufficient")
            fun test_purchase_insufficientFunds_illegalArgumentException() {
                sut.addQuarter()
                sut.addQuarter()
                sut.addQuarter()
                var exception: Exception? = null

                try {
                    sut.purchase(1f)
                } catch (e: Exception) {
                    exception = e
                }

                assertNotNull(exception)
            }

            @Test
            @DisplayName("Then any remaining balance becomes zero")
            fun test_purchase_sufficientFunds_decreasesBalanceToZero() {
                sut.addQuarter()
                sut.addQuarter()
                sut.addQuarter()

                sut.purchase(.5f)

                assertEquals(0f, sut.balance.value)
            }
        }

        @Nested
        @DisplayName("When a .25 balance remains after a purchase and it gets refunded")
        inner class Making25CentsChange {

            @Test
            @DisplayName("Then only the required count of coins should be found in CoinReturn")
            fun test_purchase_remainingBalance_refunded() {
                sut.addQuarter()
                sut.addQuarter()
                sut.addQuarter()

                sut.purchase(.5f)

                assertEquals(1, CoinReturn.size)
            }

            @Test
            @DisplayName("Then one object matching the properties of a quarter should be found in CoinReturn")
            fun test_purchase_remainingBalance_refundsAppropriateObject() {
                sut.addQuarter()
                sut.addQuarter()
                sut.addQuarter()

                sut.purchase(.5f)

                assertEquals(
                    TheoreticalCoin.Quarter.diameterMicrometers * 2,
                    CoinReturn[0].lengthMicrometers
                )
                assertEquals(
                    TheoreticalCoin.Quarter.thicknessMicrometers,
                    CoinReturn[0].widestPointMicrometers
                )
                assertEquals(
                    TheoreticalCoin.Quarter.weightMilligrams,
                    CoinReturn[0].weightMilligrams
                )
            }
        }

        @Nested
        @DisplayName("When a .35 balance remains after a purchase and it gets refunded")
        inner class Making35CentsChange {

            @Test
            @DisplayName("Then only the required count of coins should be found in CoinReturn")
            fun test_purchase_remainingBalance_refunded() {
                sut.addQuarter()
                sut.addQuarter()
                sut.addQuarter()
                sut.addDime()

                sut.purchase(.5f)

                assertEquals(2, CoinReturn.size)
            }

            @Test
            @DisplayName("Then one object matching a quarter should be found in CoinReturn")
            fun test_purchase_remainingBalance_refundsOneQuarter() {
                sut.addQuarter()
                sut.addQuarter()
                sut.addQuarter()
                sut.addDime()

                sut.purchase(.5f)

                CoinReturn.sortBy { it.weightMilligrams }
                assertEquals(
                    TheoreticalCoin.Quarter.diameterMicrometers * 2,
                    CoinReturn[0].lengthMicrometers
                )
                assertEquals(
                    TheoreticalCoin.Quarter.thicknessMicrometers,
                    CoinReturn[0].widestPointMicrometers
                )
                assertEquals(
                    TheoreticalCoin.Quarter.weightMilligrams,
                    CoinReturn[0].weightMilligrams
                )
            }

            @Test
            @DisplayName("Then one object matching a dime should be found in CoinReturn")
            fun test_purchase_remainingBalance_refundsOneDime() {
                sut.addQuarter()
                sut.addQuarter()
                sut.addQuarter()
                sut.addDime()

                sut.purchase(.5f)

                CoinReturn.sortBy { it.weightMilligrams }
                assertEquals(
                    TheoreticalCoin.Dime.diameterMicrometers * 2,
                    CoinReturn[1].lengthMicrometers
                )
                assertEquals(
                    TheoreticalCoin.Dime.thicknessMicrometers,
                    CoinReturn[1].widestPointMicrometers
                )
                assertEquals(TheoreticalCoin.Dime.weightMilligrams, CoinReturn[1].weightMilligrams)
            }
        }

        @Nested
        @DisplayName("When a .40 balance remains after a purchase and it gets refunded")
        inner class Making45CentsChange() {
            @Test
            @DisplayName("Then only the required count of coins should be found in CoinReturn")
            fun test_purchase_remainingBalance_refunded() {
                sut.addQuarter()
                sut.addQuarter()
                sut.addQuarter()
                sut.addDime()
                sut.addNickel()

                sut.purchase(.5f)

                assertEquals(3, CoinReturn.size)
            }

            @Test
            @DisplayName("Then one object matching a quarter should be found in CoinReturn")
            fun test_purchase_remainingBalance_refundsOneQuarter() {
                sut.addQuarter()
                sut.addQuarter()
                sut.addQuarter()
                sut.addDime()
                sut.addNickel()

                sut.purchase(.5f)

                CoinReturn.sortBy { it.weightMilligrams }
                assertEquals(TheoreticalCoin.Quarter.diameterMicrometers * 2 , CoinReturn[0].lengthMicrometers)
                assertEquals(TheoreticalCoin.Quarter.thicknessMicrometers, CoinReturn[0].widestPointMicrometers)
                assertEquals(TheoreticalCoin.Quarter.weightMilligrams, CoinReturn[0].weightMilligrams)
            }

            @Test
            @DisplayName("Then one object matching a dime should be found in CoinReturn")
            fun test_purchase_remainingBalance_refundsOneDime() {
                sut.addQuarter()
                sut.addQuarter()
                sut.addQuarter()
                sut.addDime()
                sut.addNickel()

                sut.purchase(.5f)

                CoinReturn.sortBy { it.weightMilligrams }
                assertEquals(TheoreticalCoin.Dime.diameterMicrometers * 2 , CoinReturn[1].lengthMicrometers)
                assertEquals(TheoreticalCoin.Dime.thicknessMicrometers, CoinReturn[1].widestPointMicrometers)
                assertEquals(TheoreticalCoin.Dime.weightMilligrams, CoinReturn[1].weightMilligrams)
            }

            @Test
            @DisplayName("Then one object matching a nickel should be found in CoinReturn")
            fun test_purchase_remainingBalance_refundsOneNickel() {
                sut.addQuarter()
                sut.addQuarter()
                sut.addQuarter()
                sut.addDime()
                sut.addNickel()

                sut.purchase(.5f)

                CoinReturn.sortBy { it.weightMilligrams }
                assertEquals(TheoreticalCoin.Nickel.diameterMicrometers * 2 , CoinReturn[2].lengthMicrometers)
                assertEquals(TheoreticalCoin.Nickel.thicknessMicrometers, CoinReturn[2].widestPointMicrometers)
                assertEquals(TheoreticalCoin.Nickel.weightMilligrams, CoinReturn[2].weightMilligrams)
            }
        }
    }
}
