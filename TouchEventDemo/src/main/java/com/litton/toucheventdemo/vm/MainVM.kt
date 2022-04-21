package com.litton.toucheventdemo.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainVM: ViewModel() {
    val mainLiveData = MutableLiveData<String>()
    fun addString(string: String){
        mainLiveData.postValue(string)
//        mainLiveData.value = string
    }
}