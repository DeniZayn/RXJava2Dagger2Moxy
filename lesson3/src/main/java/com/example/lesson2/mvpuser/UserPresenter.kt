package com.example.lesson2.mvpuser

import com.example.lesson2.data.GitHubUserRepository
import moxy.MvpPresenter
import com.example.lesson2.navigation.CustomRouter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
//        userRepository
//            .getUserByLogin(userLogin)
//            ?.let(viewState::showUser)
    }
}