package com.litton.toucheventdemo.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.litton.toucheventdemo.databinding.FragmentDemo2Binding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Demo2Fragment : Fragment() {
    private lateinit var binding: FragmentDemo2Binding
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDemo2Binding.inflate(inflater, container, false)
        binding.fl.setBackgroundColor(Color.parseColor(param1))
        binding.text.text = param2.toString()
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String="#F09A0E", param2: String="") =
            Demo2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}