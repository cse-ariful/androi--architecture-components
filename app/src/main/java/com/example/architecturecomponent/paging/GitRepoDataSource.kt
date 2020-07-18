package com.example.architecturecomponent.paging

import android.widget.Toast
import androidx.paging.PageKeyedDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitRepoDataSource :PageKeyedDataSource<Int,GitRepo>(){
    override fun loadInitial( params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, GitRepo> ) {
        val service =GitRepoServiceBuilder.buildService(GitRepoService::class.java)
        val call =service.getRepositories(FIRST_PAGE, PAGE_SIZE, TOPIC)
        call.enqueue(object : Callback<GitRepoResponse> {


            override fun onResponse(call: Call<GitRepoResponse>, response: Response<GitRepoResponse>) {
                if(response.isSuccessful){
                    val  items = response.body()?.items
                    items?.let {
                        callback.onResult(items,null, FIRST_PAGE+1)
                    }
                }
            }
            override fun onFailure(call: Call<GitRepoResponse>, t: Throwable) {
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, GitRepo>) {
        val service =GitRepoServiceBuilder.buildService(GitRepoService::class.java)
        val call =service.getRepositories(FIRST_PAGE, PAGE_SIZE, TOPIC)
        call.enqueue(object : Callback<GitRepoResponse> {


            override fun onResponse(call: Call<GitRepoResponse>, response: Response<GitRepoResponse>) {
                if(response.isSuccessful){
                    val  items = response.body()?.items
                    val key=if (response.body()?.totalCount!!>params.key)params.key+1 else 0
                    items?.let {
                        callback.onResult(items,  key)
                    }
                }
            }
            override fun onFailure(call: Call<GitRepoResponse>, t: Throwable) {
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, GitRepo>) {
        val service =GitRepoServiceBuilder.buildService(GitRepoService::class.java)
        val call =service.getRepositories(FIRST_PAGE, PAGE_SIZE, TOPIC)
        call.enqueue(object : Callback<GitRepoResponse> {


            override fun onResponse(call: Call<GitRepoResponse>, response: Response<GitRepoResponse>) {
                if(response.isSuccessful){
                    val  items = response.body()?.items
                    val key=if ( params.key>1)params.key-1 else 0
                    items?.let {
                        callback.onResult(items,  key)
                    }
                }
            }
            override fun onFailure(call: Call<GitRepoResponse>, t: Throwable) {
            }
        })
    }
    companion object{
        const val PAGE_SIZE = 10
        const val FIRST_PAGE=1
        const val TOPIC="android"
    }

}