package com.example.architecturecomponent.lifeCycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.random.Random as Random1

class DataGenerator:ViewModel(){
    private lateinit var myRandomNumber:MutableLiveData<String>

    fun geNumber():MutableLiveData<String>{
        if(!::myRandomNumber.isInitialized){
            myRandomNumber= MutableLiveData()
            this.createNumber()
        }
        return myRandomNumber;
    }

    public fun createNumber() {
        val random = Random()
        myRandomNumber.value="Number: "+(random.nextInt(10-1)+1)
    }

    /**
     * this class destroyed on this method
     */
    override fun onCleared() {
        super.onCleared()
    }
}