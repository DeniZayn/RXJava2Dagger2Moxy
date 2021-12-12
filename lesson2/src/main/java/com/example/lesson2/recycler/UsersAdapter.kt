package com.example.lesson2.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.lesson2.data.GitHubUser
import androidx.recyclerview.widget.ListAdapter
import com.example.lesson2.databinding.ViewUserBinding

class UsersAdapter(private val onUserClickListener: OnUserClickListener?): ListAdapter<GitHubUser, UserViewHolder>(UserDiff()) {

    interface OnUserClickListener {
        fun onUserPicked(user: GitHubUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemBinding = ViewUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return UserViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(getItem(position), onUserClickListener)

}