package steve.sample.vendi.machine.acceptor.filters

import steve.sample.vendi.money.MaybeCoinObject
import steve.sample.vendi.money.TheoreticalCoin
import javax.inject.Inject
import kotlin.random.Random

/**
 * By producing a current in one solenoid, and reading the magnetic field produced in a second,
 * we can determine the material composition of an inserted object by the expected impedance
 * (i.e. the overall field - the amount it was blocked by the object should be the same as the
 * amount a nickel, dime, or quarter would block it.
 */
class IdentificationProbe
@Inject
constructor() {


    /**
     * Determines which coin's acceptor should be open and for what span of time
     * @return a pair representing the coin we expect after the composition analysis
     */
    fun gateToUnlock(maybeCoin: MaybeCoinObject): TheoreticalCoin? = when (maybeCoin.producedVoltage) {
        TheoreticalCoin.Nickel.expectedVoltage -> TheoreticalCoin.Nickel
        TheoreticalCoin.Dime.expectedVoltage -> TheoreticalCoin.Dime
        TheoreticalCoin.Quarter.expectedVoltage -> TheoreticalCoin.Quarter
        else -> null
    }

    /**
     * Simulates the process of reading the material composition of an object by measuring the amount it
     * impedes the transmission of a magnetic field
     */
    private val MaybeCoinObject.producedVoltage: Float
        get() {
            val weightGrams: Float = weightMilligrams / 1000f
            val impededPerGram = when (materialComposition) {
                MaybeCoinObject.MaterialComposition.COPPER_92_NICKEL_8 -> 1.02f
                MaybeCoinObject.MaterialComposition.ZINC_98_COPPER_2 -> 1.89f
                MaybeCoinObject.MaterialComposition.COPPER_75_NICKEL_25 -> 2.30f
                MaybeCoinObject.MaterialComposition.PLASTIC -> 0.1f
                MaybeCoinObject.MaterialComposition.WOOD -> 0.05f
                MaybeCoinObject.MaterialComposition.ALUMINUM -> 3.32f
                else -> Random.nextFloat() * 10f
            }

            return weightGrams * impededPerGram
        }
}