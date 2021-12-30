package com.example.lesson2.mvpuser

import com.github.terrakok.cicerone.androidx.FragmentScreen
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.Fragment

class UserScreen(private val userLogin: String): FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        UserFragment.newInstance(userLogin)

}