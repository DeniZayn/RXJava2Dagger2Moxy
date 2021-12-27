package com.example.lesson2

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.lesson2.navigation.CustomRouter
import com.github.terrakok.cicerone.Cicerone

class App: Application() {

    @SuppressLint("StaticFieldLeak")
    object ContextHolder { lateinit var context: Context }


    override fun onCreate() {
        super.onCreate()
        ContextHolder.context = this
    }

    companion object Navigation {

        private val cicerone: Cicerone<CustomRouter> by lazy {
            Cicerone.create(CustomRouter())
        }

        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router
    }
}