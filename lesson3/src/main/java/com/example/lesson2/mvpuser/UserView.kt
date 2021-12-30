package com.example.lesson2.mvpuser

import com.example.lesson2.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : MvpView {

    @SingleState
    fun showPhoto(url: String)

    @SingleState
    fun showName(name: String)

}