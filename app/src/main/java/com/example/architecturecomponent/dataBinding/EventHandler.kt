package com.example.architecturecomponent.dataBinding

import android.content.Context
import android.widget.Toast

open class EventHandler(context:Context){
    val myContext:Context=context;
    fun onButtonClick(value:String){
        Toast.makeText(myContext,"Hello $value",Toast.LENGTH_SHORT).show()
    }
}