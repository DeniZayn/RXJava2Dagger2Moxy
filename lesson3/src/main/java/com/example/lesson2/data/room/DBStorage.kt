package com.example.lesson2.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lesson2.data.GitHubUser

@Database(exportSchema = false, entities = [GitHubUser::class], version = 1)
abstract class DBStorage: RoomDatabase() {

    abstract fun getGitHubUserDao(): GitHubUserDao

}