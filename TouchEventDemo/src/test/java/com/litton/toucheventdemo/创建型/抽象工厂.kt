package com.litton.toucheventdemo

interface TianPinFactory {
    fun productCoffee(type: String = ""): CoffeeFactory
    fun productCake(type: String = ""): CakeFactory
}

class TianPinStore : TianPinFactory {
    override fun productCoffee(type: String): CoffeeFactory {
        return when (type) {
            AMERICAN -> AmericanCoffee()
            LATTE -> CatCoffee()
            else -> AmericanCoffee()
        }
    }

    override fun productCake(type: String): CakeFactory {
        return when (type) {
            NAIYOU -> NaiYouCakeFactory()
            CAOMEI -> CaoMeiCakeFactory()
            else -> NaiYouCakeFactory()
        }
    }
}

fun testTianPinStore() {
    val tianPinStore = TianPinStore()
    tianPinStore.productCoffee().product()
    tianPinStore.productCoffee(LATTE).product()
    tianPinStore.productCake().product()
    tianPinStore.productCake(CAOMEI).product()
}