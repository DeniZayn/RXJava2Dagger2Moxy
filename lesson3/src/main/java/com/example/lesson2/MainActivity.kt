package com.example.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson2.App.Navigation.navigatorHolder
import com.example.lesson2.App.Navigation.router
import com.example.lesson2.mvpusers.UsersScreen
import com.example.lesson2.navigation.CustomNavigator

class MainActivity : AppCompatActivity() {
    private val navigator = CustomNavigator(activity = this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            router.navigateTo(UsersScreen)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}