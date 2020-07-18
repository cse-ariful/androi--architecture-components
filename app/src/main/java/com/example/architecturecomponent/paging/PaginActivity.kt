package com.example.architecturecomponent.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturecomponent.R
import kotlinx.android.synthetic.main.activity_pagin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaginActivity : AppCompatActivity() {
    val apiURl:String ="https://api.github.com/search/repositories/q=android&sortby=star&page=1&per_page=3"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagin)
        val adapter = GitRepoAdapter()
        recyclerView.layoutManager=LinearLayoutManager(this)
        val itemViewModel =ViewModelProviders.of(this).get(GitRepoViewModel::class.java)
        itemViewModel.gitRepoPagedList.observe(this, Observer {
            adapter.submitList(it)
        })
        recyclerView.adapter=adapter
    }
}