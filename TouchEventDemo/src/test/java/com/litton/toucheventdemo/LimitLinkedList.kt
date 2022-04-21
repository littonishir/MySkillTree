package com.litton.toucheventdemo

import java.util.*

class LimitLinkedList<E> : LinkedList<E>() {
    private var limitSize = 10

    fun setLimit(size: Int) {
        limitSize = size
    }

    /**
     * 限制该队列存放 limitSize 个元素，超过 limitSize 无法入队。
     */
    override fun offer(e: E): Boolean {
        return if (size == limitSize) {
            false
        } else {
            super.offer(e)
        }
    }
}