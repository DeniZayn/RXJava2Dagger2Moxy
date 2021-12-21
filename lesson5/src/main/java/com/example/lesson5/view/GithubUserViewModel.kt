package com.example.lesson5.view

import com.example.lesson5.model.entity.GithubUser

data class GithubUserViewModel(
    val login: String,
    val avatar_url: String,
    val repos_url: String,
) {
    object Mapper {
        fun map(user: GithubUser) = GithubUserViewModel(
            user.login.uppercase(), user.avatar, user.repos_url)
    }
}

