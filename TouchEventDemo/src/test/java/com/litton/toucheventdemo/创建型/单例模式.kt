package com.litton.toucheventdemo

//饿汉式
object SingletonKotlin1 {
    fun println(hello: String) {
        println(hello)
    }
}

//懒汉式加入同步锁
class SingletonKotlin2 {
    private var ourInstance: SingletonKotlin2? = null

    @get:Synchronized
    val instance: SingletonKotlin2?
        get() {
            if (ourInstance == null) {
                ourInstance = SingletonKotlin2()
            }
            return ourInstance
        }
}

//双重校验锁
class SingletonKotlin3 private constructor() {
    companion object {
        val instance: SingletonKotlin3 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonKotlin3()
        }
    }
}
