package com.litton.toucheventdemo.activity

import java.io.*

class Apple : Cloneable, Serializable {
    var name = ""

    override fun clone(): Any {
        return super.clone()
    }

    fun deepCopy(): Apple {
        val bos = ByteArrayOutputStream()
        val oos = ObjectOutputStream(bos)
        oos.writeObject(this)
        val bis = ByteArrayInputStream(bos.toByteArray())
        val ois = ObjectInputStream(bis)
        return ois.readObject() as Apple
    }
}