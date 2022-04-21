package com.litton.toucheventdemo

import android.view.View

const val Log_tag = "log_tag"


fun View.OnClickListener.setAllClickListener(vararg view: View) {
    view.forEach {
        it.setOnClickListener(this)
    }
}