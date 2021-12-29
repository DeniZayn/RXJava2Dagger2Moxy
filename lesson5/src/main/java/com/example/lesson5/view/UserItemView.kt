package com.example.lesson5.view

interface UserItemView : IItemView {
    fun setUser(login: String, avatar_url: String)
}