package com.litton.toucheventdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.LruCache
import android.widget.TextView
import com.litton.toucheventdemo.R
import java.util.LinkedHashMap

class LruCacheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lru_cache)
        findViewById<TextView>(R.id.textView2).apply {
            text = linkedHashMap().toString()
        }
    }
    private fun linkedHashMap(): LruCache<Int, Int> {
        val linkedHashMap = LruCache<Int, Int>(10)
        linkedHashMap.put(0,0)
        linkedHashMap.put(1,1)
        linkedHashMap.put(2,2)
        linkedHashMap.put(3,3)
        linkedHashMap[1]
        linkedHashMap[2]
        return linkedHashMap
    }
}