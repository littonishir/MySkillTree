package com.example.mywutong.观察者模式

import com.litton.toucheventdemo.randomInt

class Monster(val callback: HeroCallback) : Observer {

    override fun update(o: Observable) {
        callback.result(randomInt(1000),0)
    }
}