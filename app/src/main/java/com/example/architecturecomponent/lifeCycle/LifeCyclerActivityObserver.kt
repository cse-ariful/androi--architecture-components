package com.example.architecturecomponent.lifeCycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LifeCyclerActivityObserver:LifecycleObserver{
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateEvent(){
        Log.d(TAG, "onCreateEvent: ")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStartEvent() {
        Log.d(TAG, "onStartEvent: ")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeEvent(){
        Log.d(TAG, "onResumeEvent: ")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseEvent(){
        Log.d(TAG, "onPauseEvent: ")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyEvent(){
        Log.d(TAG, "onDestroyEvent: ")
    }

    companion object{
        private val  TAG:String=LifeCyclerActivityObserver::class.java.simpleName
    }

}