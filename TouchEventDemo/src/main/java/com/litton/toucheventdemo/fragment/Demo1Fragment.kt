package com.litton.toucheventdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.litton.toucheventdemo.R
import com.litton.toucheventdemo.databinding.FragmentDemo1Binding

class Demo1Fragment : Fragment() {
    private lateinit var binding: FragmentDemo1Binding
    private val titles = arrayListOf("child1", "child2", "child3")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDemo1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 3

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> Demo2Fragment.newInstance(param2 = getString(R.string.fragment_text1))
                    1 -> Demo2Fragment.newInstance("#AA240C",getString(R.string.fragment_text1))
                    2 -> Demo2Fragment.newInstance("#26B747",getString(R.string.fragment_text1))
                    else -> Demo2Fragment.newInstance()
                }
            }
        }
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }

}