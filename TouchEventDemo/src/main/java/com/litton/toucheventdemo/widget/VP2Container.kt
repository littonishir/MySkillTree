package com.litton.toucheventdemo.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

/**
 *Create by atu on 2021/1/29
 */
class VP2Container @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defaultStyle: Int = 0
) : ConstraintLayout(context, attributeSet, defaultStyle) {

    private var startX = 0
    private var startY = 0
    private lateinit var mViewPager2: ViewPager2

    override fun onFinishInflate() {
        super.onFinishInflate()
        for (index in 0 until childCount) {
            val view = getChildAt(index)
            if (view is ViewPager2)
                mViewPager2 = view
        }//若是为初始化，抛出异常。
        if (!this::mViewPager2.isInitialized) {
            throw IllegalStateException("VP2Container must has a child is viewpager2")
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val notNeedInterceptor = !mViewPager2.isUserInputEnabled
                || (mViewPager2.adapter != null && mViewPager2.adapter!!.itemCount <= 1)
        if (notNeedInterceptor) return super.onInterceptTouchEvent(ev)
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {//按下的时候 请求父布局不要拦截事件
                startX = ev.x.toInt()
                startY = ev.y.toInt()
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                val endX = ev.x.toInt()
                val endY = ev.y.toInt()
                val disX = abs(endX - startX)
                val disY = abs(endY - startY)
                if (mViewPager2.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {//水平滑动
                    dealHActionMove(endX, disX, disY)
                } else if (mViewPager2.orientation == ViewPager2.ORIENTATION_VERTICAL) {
                    dealVActionMove(endY, disX, disY)
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
            }
        }
        return super.onInterceptTouchEvent(ev)
    }


    /**
     * 处理水平冲突的问题
     * disX > disY 表示左右滑动，否则表示上下滑动
     * endX - startX > 0 表示右滑（→），否则表示左滑(←)
     */
    private fun dealHActionMove(endX: Int, disX: Int, disY: Int) {
        if (mViewPager2.adapter == null) return
        if (disX > disY) {
            val currentItem = mViewPager2.currentItem
            val itemCount = mViewPager2.adapter!!.itemCount
            Log.e("vp2", "currentItem： $currentItem itemCount： $itemCount")
            if (currentItem == 0 && endX - startX > 0 || currentItem == itemCount - 1 && endX - startX < 0) {
                parent.requestDisallowInterceptTouchEvent(false)
            } else {
                parent.requestDisallowInterceptTouchEvent(true)
            }
        } else if (disY > disX) {
            parent.requestDisallowInterceptTouchEvent(false)
        }
    }

    /**
     * 处理垂直滑动冲突
     */
    private fun dealVActionMove(endY: Int, disX: Int, disY: Int) {
        if (mViewPager2.adapter == null) return
        if (disY > disX) {
            val currentItem = mViewPager2.currentItem
            val itemCount = mViewPager2.adapter!!.itemCount
            if (currentItem == 0 && endY - startY > 0) {
                parent.requestDisallowInterceptTouchEvent(false)
            } else {
                parent.requestDisallowInterceptTouchEvent(
                    currentItem != itemCount - 1
                            || endY - startY >= 0
                )
            }
        } else if (disX > disY) {
            parent.requestDisallowInterceptTouchEvent(false)
        }
    }

}