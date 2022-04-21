package com.litton.toucheventdemo.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.litton.toucheventdemo.databinding.ActivityMyHandleBinding
import com.litton.toucheventdemo.setAllClickListener


class MyHandleActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMyHandleBinding
    private val handler = Handler(Looper.getMainLooper()) {
        Thread.sleep(2000)
        it.apply {
            binding.textView.text = "$obj $arg1 $what"
        }
        true
    }
    private val runnable = Runnable {
        binding.textView.text = "Runnable消息更新成功"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyHandleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            setAllClickListener(button12, button13)
        }


    }


    override fun onClick(v: View?) {
        when (v) {
            binding.button12 -> {
                val obtain = Message.obtain()
                obtain.target
                obtain.what = 10
                obtain.arg1 = 20
                obtain.obj = "我是字符串"
                handler.sendMessage(obtain)
            }
            binding.button13 -> {
                handler.obtainMessage()
                handler.postDelayed(runnable,1000)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}