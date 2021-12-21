package com.example.lesson5.view

import com.example.lesson5.model.entity.GithubUserRepo
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : ScreenView {
    fun showUser(user: GithubUserViewModel)
    fun updateRepos()
    fun init()
    fun showRepo(repo: GithubUserRepo)
}