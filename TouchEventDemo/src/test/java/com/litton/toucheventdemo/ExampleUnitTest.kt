package com.litton.toucheventdemo

import com.litton.toucheventdemo.结构型.testPlug
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.collections.LinkedHashMap

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        val s = null
        s?:false
//        arrayDemo()
//        stackDemo()
//        queueDemo()
//        linkedHashMap()

//        val newInstance = Singleton.newInstance()
//        SingletonDemo.instance
//        testApple()
//        testCake()
//        testTianPinStore()
        testPlug()
    }
    private fun linkedHashMap(){
        val linkedHashMap = java.util.LinkedHashMap<Int, Int>(0, 0.75f, true)
        linkedHashMap[0] = 0
        linkedHashMap[1] = 1
        linkedHashMap[2] = 2
        linkedHashMap[3] = 3
        linkedHashMap[1]
        linkedHashMap[2]
        println(linkedHashMap)
    }


    private fun arrayDemo(){
        // 1. 初始化一个size为10，默认全是0的Int数组。
        val array = Array<Int>(10) { 0 }
        // 2. 数组索引0,1,2,3的位置分别赋值为10,11,12,13。
        array[0] = 10
        array[1] = 11
        // 3. 打印输出。
        println(array[0])
        println(array[1])
        println(array[2])
    }
    fun stackDemo(){
        // 1. 创建栈
        val stack = Stack<Int>()
        // 2. 将数据元素压入栈
        stack.push(1000)
        stack.push(2000)
        stack.push(3000)
        stack.push(4000)
        println(stack)
        println("peek:${stack.peek()}")
        println("pop :${stack.pop()}")
        val search = stack.search(2000)
        println(search)
        println(stack[search])
        println(stack)
    }
    fun queueDemo(){
        val queue: Queue<String> = LimitLinkedList()
        queue.offer("1")
        queue.offer("2")
        queue.offer("3")
        queue.offer("4")
        queue.offer("5")
        println("原队列：$queue")
        queue.poll()
        queue.remove()
        queue.peek()
        queue.element()
        println("改变后队列：$queue")
    }

}