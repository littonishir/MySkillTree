package com.litton.myflavor

import android.app.Application
import android.util.Log

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e(logTag,getString(R.string.app_name)+"start")
    }
}