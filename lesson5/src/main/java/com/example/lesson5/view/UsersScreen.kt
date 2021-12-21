package com.example.lesson5.view

import com.github.terrakok.cicerone.androidx.FragmentScreen

object UsersScreen {
    fun create() = FragmentScreen { UsersFragment.newInstance() }
}