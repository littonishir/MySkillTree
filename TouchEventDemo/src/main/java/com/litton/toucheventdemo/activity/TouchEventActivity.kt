package com.litton.toucheventdemo.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.litton.toucheventdemo.Log_tag
import com.litton.toucheventdemo.databinding.ActivityTouchEventBinding
import com.litton.toucheventdemo.setAllClickListener

class TouchEventActivity : AppCompatActivity(),View.OnClickListener {
    /**
     * 默认事件分发
     * Activity dispatchTouchEvent -> MyViewGroup dispatchTouchEvent -> MyViewGroup onInterceptTouchEvent
     * -> MyView dispatchTouchEvent -> MyView onTouchEvent -> MyViewGroup onTouchEvent -> Activity onTouchEvent
     */
    lateinit var binding: ActivityTouchEventBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTouchEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.mView.setOnTouchListener { v, event ->
//            when (event?.action) {
//                MotionEvent.ACTION_DOWN -> {
//                    Log.d(Log_tag, "View OnTouchListener ACTION_DOWN 响应事件 $v")
//                }
//                MotionEvent.ACTION_MOVE -> {
//                    Log.d(Log_tag, "View OnTouchListener ACTION_MOVE 响应事件 $v")
//                }
//                MotionEvent.ACTION_UP -> {
//                    Log.d(Log_tag, "View OnTouchListener ACTION_UP 响应事件 $v")
//                }
//            }
//            true
//        }
        setAllClickListener(binding.mView)


    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(Log_tag, "Activity dispatchTouchEvent")
        val dispatchTouchEvent = super.dispatchTouchEvent(ev)
//        Log.d(Log_tag, "Activity dispatchTouchEvent:$dispatchTouchEvent")

        return dispatchTouchEvent
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(Log_tag, "Activity onTouchEvent")
        val onTouchEvent = super.onTouchEvent(event)
//        Log.d(Log_tag, "Activity onTouchEvent:$onTouchEvent")
        return onTouchEvent
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.mView -> {
                Log.d(Log_tag, "MyView 被点击了")
            }
        }
    }
}