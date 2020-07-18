package com.example.architecturecomponent.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.architecturecomponent.R
import com.example.architecturecomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding =DataBindingUtil.setContentView(this,
            R.layout.activity_main
        );
//        binding.emailTv.text="cse.ariful@gmail.com";
//        binding.nameTv.text="arof";
        binding.contact= Contact(
            "Arif",
            "cse.ariful@gmail.com"
        )
        binding.eventHandler=
            EventHandler(this)
        binding.imageUrl="https://homepages.cae.wisc.edu/~ece533/images/airplane.png"

    }
}