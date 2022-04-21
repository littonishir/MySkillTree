package com.example.mywutong.观察者模式

/**
 * 可被观察的对象
 */
open class Observable{
    private var observerList = mutableListOf<Observer>()
    //注册观察者
    fun attach(heroObserver: Observer) {
        observerList.add(heroObserver)
    }
    //删除观察者
    fun detach(heroObserver: Observer) {
        if (observerList.size == 0) return
        observerList.remove(heroObserver)
    }
    //通知所有观察者
    fun notifyObserver() {
        observerList.forEach {
            it.update(this)
        }
    }
    fun clearAllObserver(){
        observerList.clear()
    }



}