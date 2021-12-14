package com.example.lesson2.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.lesson2.data.GitHubUser

class UserDiff : DiffUtil.ItemCallback<GitHubUser>() {

    override fun areItemsTheSame(oldItem: GitHubUser, newItem: GitHubUser): Boolean {
        return oldItem.login == newItem.login
    }

    override fun areContentsTheSame(oldItem: GitHubUser, newItem: GitHubUser): Boolean {
        return oldItem == newItem
    }
}