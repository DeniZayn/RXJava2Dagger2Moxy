package com.example.lesson2

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.IllegalStateException
import java.util.concurrent.TimeUnit
import kotlin.random.Random

fun main() {
    val list = listOf(
        GitHubUser("1",1),
        GitHubUser("2",2),
        GitHubUser("3",3)
    )

    Observable.fromIterable(list)
        .distinct()
        .filter { it.login == "1" }
        .subscribe { println(it) }

}


data class GitHubUser(
    val login: String,
    val id: Int
)
