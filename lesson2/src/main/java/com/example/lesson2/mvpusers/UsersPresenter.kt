package com.example.lesson2.mvpusers

import com.example.lesson2.data.GitHubUser
import com.example.lesson2.data.GitHubUserRepository
import com.example.lesson2.mvpuser.UserScreen
import com.example.lesson2.navigation.CustomRouter
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
): MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUsers()
            .let(viewState::showUsers)
    }

    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login))

}