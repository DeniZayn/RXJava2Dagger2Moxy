package com.example.lesson5.data

import com.example.lesson5.api.GithubApi
import com.example.lesson5.model.entity.GithubUser
import com.example.lesson5.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single


class UsersDataSourceImpl(private val githubApi: GithubApi) : UsersDataSource {
    override fun getUsers(): Single<List<GithubUser>> = githubApi.getUsers()

    override fun getUserByLogin(login: String?): Maybe<GithubUser> {
        return if (login != null) {
            githubApi.getUserByLogin(login)
                .toMaybe()
        } else {
            Maybe.empty()
        }


    }

    override fun getUserRepos(url: String): Maybe<List<GithubUserRepo>> =
        githubApi.getUserRepos(url).toMaybe()

}