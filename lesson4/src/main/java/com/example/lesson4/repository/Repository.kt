package com.example.lesson4.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import java.io.File

interface Repository {

    fun convertJPGtoPNG(file: File): Completable
    fun getDir(): Observable<File>
    fun saveJPGFile(fileRepo: File?): Completable
}