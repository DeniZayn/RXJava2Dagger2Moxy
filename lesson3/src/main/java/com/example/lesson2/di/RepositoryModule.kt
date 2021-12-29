package com.example.lesson2.di

import com.example.lesson2.data.GitHubUserRepository
import com.example.lesson2.data.GitHubUserRepositoryImpl
import com.example.lesson2.data.retrofit.GitHubApi
import com.example.lesson2.data.room.DBStorage
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(@Named("prod") api: GitHubApi, dbStorage: DBStorage): GitHubUserRepository {
        return GitHubUserRepositoryImpl(api, dbStorage)
    }
}