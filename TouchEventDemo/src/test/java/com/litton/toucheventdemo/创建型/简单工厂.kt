package com.litton.toucheventdemo

const val AMERICAN = "AMERICAN"
const val LATTE = "LATTE"

interface CoffeeFactory {
    fun product()
}

class AmericanCoffee : CoffeeFactory {
    override fun product() {
        println("生产美式咖啡")
    }
}

class CatCoffee : CoffeeFactory {
    override fun product() {
        println("生产拿铁咖啡")
    }
}

class CoffeeStore {
    fun getCoffee(string: String): CoffeeFactory {
        return when (string) {
            AMERICAN -> AmericanCoffee()
            LATTE -> CatCoffee()
            else -> AmericanCoffee()
        }
    }
}