package com.litton.toucheventdemo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import androidx.core.view.marginRight
import androidx.core.view.marginStart
import androidx.core.view.marginTop

class TagLayout : ViewGroup {
    val childRectList = mutableListOf<Rect>()

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {

    }

    /**
     *
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val mWidth = MeasureSpec.getSize(widthMeasureSpec)
        var mHeight: Int
        var widthUse = 0
        var heightUse = 0
        var itemWidth = 0
        var itemHeight = 0
        var itemMarginStart = 0
        var itemMarginEnd = 0
        var itemTopMargin = 0
        var itemBottomMargin = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUse)
            if (widthUse + child.measuredWidth > mWidth) {
                widthUse = 0
                heightUse += itemHeight+itemTopMargin+itemBottomMargin
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUse)
            }
            itemWidth = child.measuredWidth
            itemHeight = child.measuredHeight
            val lp = child.layoutParams as MarginLayoutParams
            itemMarginStart = lp.marginStart
            itemMarginEnd = lp.marginEnd
            itemTopMargin = lp.topMargin
            itemBottomMargin = lp.bottomMargin
            val rect = Rect()
            rect.set(widthUse+itemMarginStart,heightUse+itemTopMargin ,widthUse+itemWidth+itemMarginEnd,heightUse+itemHeight+itemBottomMargin)
            childRectList.add(rect)
            widthUse += child.measuredWidth+itemMarginEnd+itemMarginStart
        }
        mHeight = heightUse + itemHeight+itemBottomMargin+itemTopMargin
        setMeasuredDimension(resolveSize(mWidth,widthMeasureSpec), resolveSize(mHeight,heightMeasureSpec))
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for (i in 0 until childCount) {
            val childAt = getChildAt(i)
            val rect = childRectList[i]
            childAt.layout(rect.left, rect.top, rect.right, rect.bottom)
        }
    }


    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }
}