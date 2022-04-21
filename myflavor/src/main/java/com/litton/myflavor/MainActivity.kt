package com.litton.myflavor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.text).apply {
            text = "${BuildConfig.FLAVOR} ${getString(R.string.app_is_pay)}"
        }
    }
}