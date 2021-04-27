package steve.sample.vendi.money


sealed class TheoreticalCoin(
    val currencyValue: Float,
    val weightMilligrams: Int,
    val diameterMicrometers: Int,
    val thicknessMicrometers: Int,
    val expectedVoltage: Float,
    val isAccepted: Boolean
) {

    object Penny: TheoreticalCoin(
        currencyValue = .01f,
        weightMilligrams = 2500,
        diameterMicrometers = 19050,
        thicknessMicrometers = 1520,
        expectedVoltage = 4.725f,
        isAccepted = false
    )

    object Nickel: TheoreticalCoin(
        currencyValue = .05f,
        weightMilligrams = 5000,
        diameterMicrometers = 21210,
        thicknessMicrometers = 1950,
        expectedVoltage = 11.500f,
        isAccepted = true
    )

    object Dime: TheoreticalCoin(
        currencyValue = .1f,
        weightMilligrams = 2268,
        diameterMicrometers = 17910,
        thicknessMicrometers = 1350,
        expectedVoltage = 2.3133597f,
        isAccepted = true
    )

    object Quarter: TheoreticalCoin(
        currencyValue = .25f,
        weightMilligrams = 5670,
        diameterMicrometers = 24260,
        thicknessMicrometers = 1750,
        expectedVoltage = 5.7834f,
        isAccepted = true
    )

    companion object {
        val all: List<TheoreticalCoin> = listOf(Quarter, Penny, Nickel, Dime, Quarter)
    }
}