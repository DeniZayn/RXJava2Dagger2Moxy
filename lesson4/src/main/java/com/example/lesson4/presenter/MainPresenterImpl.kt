package com.example.lesson4.presenter

import androidx.core.net.toUri
import com.example.lesson4.MainView
import com.example.lesson4.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.File



 class MainPresenterImpl(private val view: MainView, private val repo: Repository) : MainPresenter {

    override fun saveJPGFile() {
        repo.getDir()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe(
                { it ->
                    repo.saveJPGFile(it)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                            { view.showToast("Saved JPG") },
                            { it.message?.let { message -> view.showError(message) } })
                },
                { it.message?.let { message -> view.showError(message) } })
    }

    override fun readAndShowJPG() {
        repo.getDir()
            .subscribeOn(Schedulers.io())
            .map { File(it, "sample.jpg") }
            .map { it.absolutePath }
            .map { it.toUri() }
            .map { it.toString() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { view.showJPGImage(it) },
                { it.message?.let { it1 -> view.showError(it1) } })
    }

     override fun showConvertDialog() {
        view.showDialog()
    }

    override fun convertJPGtoPNG() {
        repo.getDir()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({ it ->
                repo.convertJPGtoPNG(it)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { view.showToast("Saved PNG") },
                        { it.message?.let { message -> view.showToast(message) } })
            },
                { it.message?.let { message -> view.showError(message) } })
    }
}