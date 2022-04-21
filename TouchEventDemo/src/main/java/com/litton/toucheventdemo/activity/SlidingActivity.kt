package com.litton.toucheventdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.litton.toucheventdemo.R
import com.litton.toucheventdemo.databinding.ActivitySlidingBinding
import com.litton.toucheventdemo.fragment.Demo1Fragment
import com.litton.toucheventdemo.fragment.Demo2Fragment

class SlidingActivity : AppCompatActivity() {
    lateinit var binding: ActivitySlidingBinding
    private val titles = arrayListOf("Tab 1", "Tab 2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlidingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = titles.size

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> Demo1Fragment()
                    1 -> Demo2Fragment.newInstance("#AFB7C7",getString(R.string.fragment_text2))
                    else -> Demo2Fragment.newInstance()
                }
            }
        }
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}