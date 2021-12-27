package com.example.lesson2.navigation

import com.github.terrakok.cicerone.Router

class CustomRouter : Router() {

    interface Command {
        fun execute(navigator: CustomNavigator)
    }

    fun openDeepLink(deepLinkUserid: String) {
        executeCommands(OpenDeepLink(deepLinkUserid))
    }
}