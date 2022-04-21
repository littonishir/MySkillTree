package com.example.mywutong.观察者模式

class Hero:Observable(),HeroCallback{
    var name:String = "林克"
    var count = 1000

    fun move(){
        notifyObserver()
    }

    override fun result(int: Int, type: Int) {
        if (type==0){
            hurt(int)
        }else{
            addCount(int)
        }
    }

    fun hurt(i: Int){
        count-=i
        if (count<0){
            count=0
            println("$name 受到致命攻击:$i 当场死亡")
        }else {
            println("$name 受到攻击:$i 当前血量:$count")
        }
    }
    fun addCount(i: Int){
        if (count==0) return
        count+=i
        if (count>1000){
            count=1000
            println("$name 生命回复:$i 血量已回复满:$count ")
        }else {
            println("$name 生命回复:$i 当前血量:$count")
        }
    }

}