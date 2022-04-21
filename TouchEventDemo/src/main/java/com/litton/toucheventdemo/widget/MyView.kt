package com.litton.toucheventdemo.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.litton.toucheventdemo.Log_tag

class MyView : View {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        Log.d(Log_tag,"MyView dispatchTouchEvent")
        val dispatchTouchEvent = super.dispatchTouchEvent(event)
//        Log.d(Log_tag,"MyView dispatchTouchEvent:$dispatchTouchEvent")
        return dispatchTouchEvent
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        Log.d(Log_tag,"MyView onTouchEvent")
        val onTouchEvent = super.onTouchEvent(event)
//        Log.d(Log_tag,"MyView onTouchEvent:$onTouchEvent")
        return onTouchEvent
    }

}