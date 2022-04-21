package com.litton.toucheventdemo.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout
import com.litton.toucheventdemo.Log_tag

class MyViewGroup : FrameLayout {
    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        Log.d(Log_tag, "MyViewGroup onInterceptTouchEvent")
        val dispatchTouchEvent = super.dispatchTouchEvent(ev)
//        Log.d(Log_tag, "MyViewGroup dispatchTouchEvent:$dispatchTouchEvent")
        return dispatchTouchEvent
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        Log.d(Log_tag, "MyViewGroup onInterceptTouchEvent")
        val onInterceptTouchEvent = super.onInterceptTouchEvent(ev)
//        Log.d(Log_tag, "MyViewGroup onInterceptTouchEvent:$onInterceptTouchEvent")
        return onInterceptTouchEvent
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        Log.d(Log_tag, "MyViewGroup onTouchEvent")
        val onTouchEvent = super.onTouchEvent(event)
//        when (event.action) {
//            MotionEvent.ACTION_DOWN -> {
//                Log.d(Log_tag, "MyViewGroup 手指按下")
//            }
//            MotionEvent.ACTION_MOVE -> {
//                Log.d(Log_tag, "MyViewGroup 手指移动")
//            }
//            MotionEvent.ACTION_CANCEL -> {
//                Log.d(Log_tag, "MyViewGroup 手指取消")
//            }
//        }
//        Log.d(Log_tag, "MyViewGroup onTouchEvent:$onTouchEvent")
        return onTouchEvent
    }

}