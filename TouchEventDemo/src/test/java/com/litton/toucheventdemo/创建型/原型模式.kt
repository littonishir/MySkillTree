package com.litton.toucheventdemo.创建型


class Apple : Cloneable {
    var description = ""
    var images = ArrayList<String>()

    public override fun clone(): Apple {
        val clone = super.clone() as Apple
        clone.description = this.description
        clone.images = this.images.clone() as ArrayList<String>
        return clone
    }

    override fun toString(): String {
        return "$description ${hashCode()} $images"
    }
}

fun testApple() {
    val apple = Apple()
    apple.description = "红苹果"
    apple.images.add("图片1")
    apple.images.add("图片2")
    val apple2 = apple.clone()
    apple2.description = "青苹果"
    apple2.images.clear()
    apple2.images.add("图片5")
    apple2.images.add("图片6")
    println(apple.toString())
    println(apple2.toString())
    println("apple 和 apple2 是同一个对象吗？ ${apple2 === apple}")
    //红苹果 490077806 [图片1, 图片2]
    //青苹果 891847262 [图片5, 图片6]
    //apple 和 apple2 是同一个对象吗？ false
}