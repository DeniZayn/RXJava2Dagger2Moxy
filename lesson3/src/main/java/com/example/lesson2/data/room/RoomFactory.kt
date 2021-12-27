package com.example.lesson2.data.room

import androidx.room.Room
import com.example.lesson2.App

object RoomFactory {

    private val database: DBStorage by lazy {
        Room.databaseBuilder(App.ContextHolder.context, DBStorage::class.java, "github.db")
            .build()
    }

    fun create(): DBStorage = database
}