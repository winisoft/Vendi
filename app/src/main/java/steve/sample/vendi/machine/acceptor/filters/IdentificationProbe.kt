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
        get() = when(materialComposition) {
            MaybeCoinObject.MaterialComposition.COPPER_92_NICKEL_8 -> 2.40f
            MaybeCoinObject.MaterialComposition.ZINC_98_COPPER_2 -> 2.95f
            MaybeCoinObject.MaterialComposition.COPPER_75_NICKEL_25 -> 3.68f
            MaybeCoinObject.MaterialComposition.PLASTIC -> 0.2f
            MaybeCoinObject.MaterialComposition.WOOD -> 0.01f
            MaybeCoinObject.MaterialComposition.ALUMINUM -> 3.91f
            else -> Random.nextFloat() * 10f
        }.let {
            it * (weightMilligrams / 1000)
        }

    companion object {
        const val SOLENOID_A_AMPERES = 1.0f
    }
}