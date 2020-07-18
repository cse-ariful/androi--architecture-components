package com.example.architecturecomponent.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.architecturecomponent.R
import kotlinx.android.synthetic.main.list_item.view.*

class GitRepoAdapter : PagedListAdapter<GitRepo, GitRepoAdapter.RepoViewHolder>(REPO_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo=getItem(position)
        repo?.let {
            holder.setData(repo)
        }
    }


    class RepoViewHolder(val view:View) :RecyclerView.ViewHolder(view){
        fun setData(repo: GitRepo) {
            view.repo_Name.text=repo.fullName
            view.repo_Description.text=repo.description
            view.repo_language.text=repo.language
            view.repo_Star.text=repo.stars.toString()
            view.repo_fork.text=repo.forks.toString()
        }

    }

    companion object{
        private val REPO_COMPARATOR=object:DiffUtil.ItemCallback<GitRepo>(){
            override fun areItemsTheSame(oldItem: GitRepo, newItem: GitRepo): Boolean {
                return oldItem.fullName==newItem.fullName
            }

            override fun areContentsTheSame(oldItem: GitRepo, newItem: GitRepo): Boolean {
                return oldItem.description== newItem.description
            }
        }
    }
}