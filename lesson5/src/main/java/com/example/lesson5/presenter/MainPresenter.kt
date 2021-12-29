package com.example.lesson5.presenter

import com.example.lesson5.view.MainView
import com.example.lesson5.view.UsersScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter (

    private val router: Router,
    ) : MvpPresenter<MainView>() {

        override fun onFirstViewAttach() {
            super.onFirstViewAttach()
            router.newRootScreen(UsersScreen.create())
        }

        fun back() = router.exit()

}

