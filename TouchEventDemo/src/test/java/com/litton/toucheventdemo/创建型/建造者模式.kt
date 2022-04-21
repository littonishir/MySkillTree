package com.litton.toucheventdemo

class PC {
    var cpu: String = ""
    var mainboard: String = ""
    var gpu: String = ""
}

/**
 * PC电脑建造者
 * 设置中央处理器
 * 设置主板
 * 设置显卡
 */
abstract class PCBuilder {
    protected val mPC = PC()
    abstract fun setCPU()
    abstract fun setMainBoard()
    abstract fun setGPU()
    abstract fun createPC(): PC
}

class GamePC : PCBuilder() {
    private val tag = "游戏主机"
    override fun setCPU() {
        println("$tag 正在组装CPU ${mPC.cpu}")
        mPC.cpu = "酷睿i9-12900K"
    }

    override fun setMainBoard() {
        println("$tag 正在组装主板 ${mPC.mainboard}")
        mPC.mainboard = "B550"
    }

    override fun setGPU() {
        println("$tag 正在组装显卡 ${mPC.gpu}")
        mPC.gpu = "RTX 3090 Ti"
    }

    override fun createPC(): PC {
        println("$tag 已安装完成 可以通知客户取货")
        return mPC
    }
}

class HomePC : PCBuilder() {
    private val tag = "家用主机"
    override fun setCPU() {
        println("$tag 正在组装CPU ${mPC.cpu}")
        mPC.cpu = "酷睿i5"
    }

    override fun setMainBoard() {
        println("$tag 正在组装主板 ${mPC.mainboard}")
        mPC.mainboard = "B450"
    }

    override fun setGPU() {
        println("$tag 正在组装显卡 ${mPC.gpu}")
        mPC.gpu = "GTX 1650"
    }

    override fun createPC(): PC {
        println("$tag 已安装完成 可以通知客户取货")
        return mPC
    }
}

class Director(private val pcBuilder: PCBuilder) {
    fun construct(): PC {
        pcBuilder.setCPU()
        pcBuilder.setMainBoard()
        pcBuilder.setGPU()
        return pcBuilder.createPC()
    }
}

fun testBuilder() {
    val director = Director(GamePC())
    val director2 = Director(GamePC())
    director.construct()
    ComputerBuilder.Builder
        .setCPU("ok")
        .setMainBoard("HD4000")
        .setGPU("GTX 650")
        .create()
        .show()
}

class ComputerController {
    object Computer {
        var tag = "自定義主機"
        var cpu: String = ""
        var mainboard: String = ""
        var gpu: String = ""
    }
}

class ComputerBuilder private constructor() {
    private var tag: String = ""
    private var cpu: String = ""
    private var gpu: String = ""
    private var mainboard: String = ""

    constructor(builder: Builder) : this() {
        cpu = ComputerController.Computer.cpu
        tag = ComputerController.Computer.tag
        gpu = ComputerController.Computer.gpu
        mainboard = ComputerController.Computer.mainboard
    }

    object Builder {
        fun setCPU(string: String): Builder {
            println("${ComputerController.Computer.tag} 正在组装CPU $string")
            ComputerController.Computer.cpu = string
            return this
        }

        fun setMainBoard(string: String): Builder {
            println("${ComputerController.Computer.tag} 正在组装主板 $string")
            ComputerController.Computer.mainboard = string
            return this
        }

        fun setGPU(string: String): Builder {
            println("${ComputerController.Computer.tag} 正在组装显卡 $string")
            ComputerController.Computer.gpu = string
            return this
        }

        fun create(): ComputerBuilder {
            println("${ComputerController.Computer.tag} 已安装完成 可以通知客户取货")
            return ComputerBuilder(this)
        }
    }

    fun show() {
        println("$tag $cpu $mainboard $gpu 展示")
    }
}

