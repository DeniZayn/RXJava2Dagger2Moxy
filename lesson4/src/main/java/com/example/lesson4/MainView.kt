package com.example.lesson4

interface MainView {

    fun showError(message: String)
    fun showJPGImage(uriString: String)
    fun showToast(message: String)
    fun showDialog()

}