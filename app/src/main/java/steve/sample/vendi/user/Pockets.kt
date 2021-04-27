package steve.sample.vendi.user

import steve.sample.vendi.money.MaybeCoinObject
import steve.sample.vendi.money.TheoreticalCoin


/**
 * Models a user's available items
 */
object Pockets {

    val quarter = object: MaybeCoinObject {
        override val weightMilligrams = TheoreticalCoin.Quarter.weightMilligrams
        override val lengthMicrometers = TheoreticalCoin.Quarter.diameterMicrometers * 2
        override val widestPointMicrometers = TheoreticalCoin.Quarter.thicknessMicrometers
        override val materialComposition = MaybeCoinObject.MaterialComposition.COPPER_92_NICKEL_8
    }
    val nickel = object: MaybeCoinObject {
        override val weightMilligrams = TheoreticalCoin.Nickel.weightMilligrams
        override val lengthMicrometers = TheoreticalCoin.Nickel.diameterMicrometers * 2
        override val widestPointMicrometers = TheoreticalCoin.Nickel.thicknessMicrometers
        override val materialComposition = MaybeCoinObject.MaterialComposition.COPPER_75_NICKEL_25
    }
    val dime = object: MaybeCoinObject {
        override val weightMilligrams = TheoreticalCoin.Dime.weightMilligrams
        override val lengthMicrometers = TheoreticalCoin.Dime.diameterMicrometers * 2
        override val widestPointMicrometers = TheoreticalCoin.Dime.thicknessMicrometers
        override val materialComposition = MaybeCoinObject.MaterialComposition.COPPER_92_NICKEL_8
    }
    val penny = object: MaybeCoinObject {
        override val weightMilligrams = TheoreticalCoin.Penny.weightMilligrams
        override val lengthMicrometers = TheoreticalCoin.Penny.diameterMicrometers * 2
        override val widestPointMicrometers = TheoreticalCoin.Penny.thicknessMicrometers
        override val materialComposition = MaybeCoinObject.MaterialComposition.ZINC_98_COPPER_2
    }
    val button = object: MaybeCoinObject {
        override val weightMilligrams = 1250
        override val lengthMicrometers = 400
        override val widestPointMicrometers = 200
        override val materialComposition = MaybeCoinObject.MaterialComposition.PLASTIC
    }
    val woodenNickel = object: MaybeCoinObject {
        override val weightMilligrams = TheoreticalCoin.Nickel.weightMilligrams
        override val lengthMicrometers = TheoreticalCoin.Nickel.diameterMicrometers * 2
        override val widestPointMicrometers = TheoreticalCoin.Nickel.thicknessMicrometers
        override val materialComposition = MaybeCoinObject.MaterialComposition.WOOD
    }

    /**
     * To keep it simple, multiplication indicates the maybe coin object gets added that many times
     */
    operator fun MaybeCoinObject.times(count: Int): Iterable<MaybeCoinObject> {
        return mutableListOf<MaybeCoinObject>().apply {
            repeat(count) { add(this@times) }
        }
    }

    val omwToCoinstarMachine = mutableListOf<MaybeCoinObject>().apply {
        addAll(quarter * 25)
        addAll(nickel * 10)
        addAll(dime * 25)
        addAll(button * 4)
        addAll(woodenNickel * 2)
    }

}