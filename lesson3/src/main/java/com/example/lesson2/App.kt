package com.example.lesson2

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.lesson2.di.ApplicationComponent
import com.example.lesson2.di.DaggerApplicationComponent
import com.example.lesson2.navigation.CustomRouter
import com.github.terrakok.cicerone.Cicerone

class App: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()

    }

    companion object{
        lateinit var instance: App
    }

}