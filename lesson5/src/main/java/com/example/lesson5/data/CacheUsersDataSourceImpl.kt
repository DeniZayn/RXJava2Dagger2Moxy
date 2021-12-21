package com.example.lesson5.data

object CacheUsersDataSourceFactory {

    fun create(): CacheUsersDataSource = CacheUsersDataSourceImpl()
}