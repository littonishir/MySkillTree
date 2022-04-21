package com.litton.toucheventdemo

const val NAIYOU = "NAIYOU"
const val CAOMEI = "CAOMEI"

class Cake(private val name: String) {
    fun eat() {
        println("$name 很好吃")
    }
}

interface CakeFactory {
    fun product(): Cake
}

class NaiYouCakeFactory : CakeFactory {
    override fun product(): Cake {
        val cs = "奶油蛋糕"
        println("生产$cs")
        return Cake(cs)
    }
}

class CaoMeiCakeFactory : CakeFactory {
    override fun product(): Cake {
        val cs = "草莓蛋糕"
        println("生产$cs")
        return Cake(cs)
    }
}

class CakeStore() {

    fun orderCake(cakeFactory: CakeFactory) {
        val cake = cakeFactory.product()
        cake.eat()
    }
}

fun testCake() {
    val cakeStore = CakeStore()
    cakeStore.orderCake(NaiYouCakeFactory())
    cakeStore.orderCake(CaoMeiCakeFactory())
}

