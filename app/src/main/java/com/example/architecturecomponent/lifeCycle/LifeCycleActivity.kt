package com.example.architecturecomponent.lifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.architecturecomponent.R
import kotlinx.android.synthetic.main.activity_life_cycle.*

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        lifecycle.addObserver(LifeCyclerActivityObserver())
        val model = ViewModelProviders.of(this).get(DataGenerator::class.java)

        val rand:MutableLiveData<String> = model.geNumber()
        rand.observe(this, Observer { number->
            randTv.text=number;
        })
        bRandom.setOnClickListener{
            model.createNumber()
        }
    }
}