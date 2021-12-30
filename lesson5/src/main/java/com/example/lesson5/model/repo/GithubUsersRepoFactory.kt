package com.example.lesson5.model.repo

import com.example.lesson5.data.CacheUsersDataSourceFactory
import com.example.lesson5.data.UsersDataSourceFactory

object GithubUsersRepoFactory {
    fun create(): IGithubUsersRepo = GithubUsersRepo(
        UsersDataSourceFactory.create(),
        CacheUsersDataSourceFactory.create())
}