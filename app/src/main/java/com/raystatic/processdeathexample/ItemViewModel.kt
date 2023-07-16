package com.raystatic.processdeathexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class ItemViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val counterKey = "counter_key"

//    var counter = MutableLiveData<Int>(0)
    var counter = savedStateHandle.getLiveData<Int>(counterKey, 0)
    private set

    fun increment() {
        var count = counter.value ?: 0
//        counter.value = ++count
        savedStateHandle[counterKey] = ++count
    }

    fun decrement() {
        var count = counter.value ?: 0
//        counter.value = --count
        savedStateHandle[counterKey] = --count
    }

}