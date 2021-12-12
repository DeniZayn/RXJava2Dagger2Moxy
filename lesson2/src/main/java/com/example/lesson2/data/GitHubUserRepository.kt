package com.example.lesson2.data

import android.security.identity.AccessControlProfileId

interface  GitHubUserRepository {

    fun getUsers(): List<GitHubUser>

    fun getUserByLogin(userId: String): GitHubUser?
}