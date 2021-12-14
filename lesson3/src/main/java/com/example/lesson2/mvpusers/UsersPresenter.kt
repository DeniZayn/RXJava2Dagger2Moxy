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

        userRepository.getIds()
            .flatMap { userRepository.getUserById(it) }
            .subscribe(
                { result -> viewState.showUsers(listOf(result)) },
                {}
            )

}

    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login))

}