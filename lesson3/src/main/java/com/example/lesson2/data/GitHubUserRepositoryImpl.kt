package com.example.lesson2.data


import com.example.lesson2.data.retrofit.GitHubApi
import com.example.lesson2.data.retrofit.GitHubApiFactory
import com.example.lesson2.data.room.DBStorage
import com.example.lesson2.data.room.RoomFactory
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


 class GitHubUserRepositoryImpl
 @Inject constructor(
    private val gitHubApi: GitHubApi,
    private val roomDb: DBStorage
    ) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUser>> {
        return roomDb.getGitHubUserDao().getUsers()
            .flatMap {
                if (it.isEmpty()) {
                    gitHubApi.fetchUsers()
                        .map { resultFromServer ->
                            roomDb.getGitHubUserDao().saveUser(resultFromServer)
                            resultFromServer
                        }
                } else {
                    Single.just(it)
                }
            }
    }

    override fun getUserByLogin(userId: String): Single<GitHubUser> {
        return gitHubApi.fetchUserByLogin(userId)
    }
}