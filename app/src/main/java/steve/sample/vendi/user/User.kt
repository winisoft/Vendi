package steve.sample.vendi.user

import steve.sample.vendi.money.MaybeCoinObject

class User(
    val pocket: MutableList<MaybeCoinObject> = Pockets.omwToCoinstarMachine
)