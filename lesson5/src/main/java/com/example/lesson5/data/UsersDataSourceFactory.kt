package com.example.lesson5.data

import com.example.lesson5.api.GithubApiFactory

object UsersDataSourceFactory {
    fun create() = UsersDataSourceImpl(GithubApiFactory.create())
}