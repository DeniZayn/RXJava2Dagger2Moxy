package com.example.lesson4.repository

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.lesson4.App
import com.example.lesson4.R
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import android.os.Environment

class RepositoryImpl : Repository {

    companion object {
        const val JPG_FILE = "sample.jpg"
        const val PNG_FILE = "drawable/sample.png"
    }

    override fun getDir(): Observable<File> {
        var sdCard: File? = null
        val sdState = Environment.getExternalStorageState()
        if (sdState.equals(Environment.MEDIA_MOUNTED)) {
            try {
                sdCard = App.instance.applicationContext
                    .getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        } else if (sdState.equals(Environment.MEDIA_SHARED)) {
            try {
                sdCard = App.instance.filesDir
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
        val sdCardCat = File(sdCard, "/Lesson4Images")
        sdCardCat.mkdir()
        return Observable.just(sdCardCat)
    }

    override fun saveJPGFile(fileRepo: File?): Completable = Completable.create { emitter ->
        saveJPG(fileRepo).let {
            if (it) {
                emitter.onComplete()
            } else {
                emitter.onError(RuntimeException("Error"))
                return@create
            }
        }
    }

    private fun saveJPG(fileRepo: File?): Boolean {
        val file = File(fileRepo, JPG_FILE)
        if (file.exists()) file.delete()
        val bitmap = BitmapFactory.decodeResource(App.instance.resources, R.drawable.sample)
        var fOut: OutputStream? = null
        return try {
            fOut = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut)
            fOut.flush()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        } finally {
            fOut?.close()
        }
    }

    override fun convertJPGtoPNG(file: File): Completable = Completable.create { emitter ->
        convertToPNG(file).let {
            if (it) {
                emitter.onComplete()
            } else {
                emitter.onError(RuntimeException("WAF/ Error"))
            }
        }
    }

    private fun convertToPNG(file: File): Boolean {
        var fOut: OutputStream? = null
        val oldFile = File(file, JPG_FILE)
        val bitmap = BitmapFactory.decodeFile(oldFile.absolutePath)
        val newFile = File(file, PNG_FILE)
        return try {
            fOut = FileOutputStream(newFile)
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, fOut)
            fOut.flush()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        } finally {
            fOut?.close()
        }
    }

}