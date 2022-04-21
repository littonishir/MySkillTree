package com.litton.toucheventdemo.结构型

/**
 * 香港插头
 * 是英式标准，在国内无法直接使用
 * */
open class HongKongPlug {
    fun chargeHongKong() {
        println("香港插头,充电中...")
    }
}

/**
 * 大陆标准接口
 */
interface MainlandTarget {
    fun charge()
}

/**
 * 大陆标准插头
 */
class MainlandPlug : MainlandTarget {
    override fun charge() {
        println("大陆插头,充电中...")
    }
}

/**
 * 适配器（转接头）
 * 实现方式：类的适配器模式
 */
class PlugAdapter : HongKongPlug(), MainlandTarget {
    override fun charge() {
        super.chargeHongKong()
    }
}

/**
 * 适配器（转接头）
 * 实现方式：对象的适配器模式
 */
class PlugAdapter2(private val hongKongPlug: HongKongPlug) : MainlandTarget {
    override fun charge() {
        hongKongPlug.chargeHongKong()
    }
}

/**
 * 测试发现
 * 1.大陆标准插头在大陆可正常使用
 * 2.香港插头在使用转接头后在大陆可正常使用
 */
fun testPlug() {
    MainlandPlug().charge()
    PlugAdapter().charge()
    PlugAdapter2(HongKongPlug()).charge()
}