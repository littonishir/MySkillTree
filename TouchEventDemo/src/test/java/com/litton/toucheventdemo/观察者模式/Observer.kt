package com.example.mywutong.观察者模式

/**
 * 观察者需实现的接口
 */
interface Observer {
    fun update(o: Observable)
}
interface HeroCallback{
    fun result(int: Int,type:Int)
}