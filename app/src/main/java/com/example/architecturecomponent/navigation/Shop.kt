package com.example.architecturecomponent.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.architecturecomponent.R
import kotlinx.android.synthetic.main.fragment_shop.*
import java.util.*

class Shop : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b_about.setOnClickListener(View.OnClickListener {
            val nexAction = ShopDirections.toAbout();
            nexAction.setProductCount(Random().nextInt(200));
            Navigation.findNavController(it).navigate(nexAction)
           // Navigation.findNavController(it).navigate(R.id.about_fragment)
          //  Navigation.findNavController(it).navigate(R.id.to_about)
        })
    }


}