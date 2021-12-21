package com.example.lesson5.api

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response
import com.example.lesson5.BuildConfig.GITHUB_USER_NAME
import com.example.lesson5.BuildConfig.GITHUB_USER_PASS


object GithubApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .header("Authorization", Credentials.basic(GITHUB_USER_NAME, GITHUB_USER_PASS))
                .build()
        )
}