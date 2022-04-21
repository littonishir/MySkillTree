package com.litton.toucheventdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.litton.toucheventdemo.Log_tag
import com.litton.toucheventdemo.databinding.ActivityVmLdLcBinding
import com.litton.toucheventdemo.vm.MainVM

class VmLdLcActivity : AppCompatActivity() {
    lateinit var mainVM: MainVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflate = ActivityVmLdLcBinding.inflate(layoutInflater)
        setContentView(inflate.root)
        mainVM = ViewModelProvider(this).get(MainVM::class.java)
        mainVM.mainLiveData.observe(this) {
            Log.e(Log_tag, "onChange:$it")
        }
    }
}