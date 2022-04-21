package com.litton.toucheventdemo.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.litton.toucheventdemo.R
import com.litton.toucheventdemo.databinding.ActivityMainBinding
import com.litton.toucheventdemo.setAllClickListener

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener(this)
        binding.apply {
            setAllClickListener(button,button2,button3,button4,button5,button6)
        }
        val builder = AlertDialog.Builder(this)
        builder.setTitle("")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.button.id -> {
                startActivity(Intent(this, TouchEventActivity::class.java))
            }
            binding.button2.id -> {
                startActivity(Intent(this, TagLayoutActivity::class.java))

            }
            binding.button3.id -> {
                startActivity(Intent(this, SlidingActivity::class.java))
            }
            binding.button4.id -> {
                startActivity(Intent(this, MyHandleActivity::class.java))
            }
            binding.button5.id -> {
                startActivity(Intent(this, LruCacheActivity::class.java))

            }
            binding.button6.id -> {

            }
        }
    }
}