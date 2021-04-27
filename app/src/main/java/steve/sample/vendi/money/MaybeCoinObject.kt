package steve.sample.vendi.money

interface MaybeCoinObject {

    val weightMilligrams: Int

    val lengthMicrometers: Int

    val widestPointMicrometers: Int

    val materialComposition: MaterialComposition
    
    /**
     * The voltage produced in the coin acceptor's identification probe when it sits between
     * the solenoid one field and the second solenoid reading it.
     */
    enum class MaterialComposition {
        ZINC_98_COPPER_2,
        COPPER_75_NICKEL_25,
        COPPER_92_NICKEL_8,
        PLASTIC,
        WOOD,
        ALUMINUM,
        UNKNOWN
    }
}