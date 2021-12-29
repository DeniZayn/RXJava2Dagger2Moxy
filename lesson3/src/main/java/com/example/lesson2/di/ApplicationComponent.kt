package com.example.lesson2.di

import android.content.Context
import com.example.lesson2.MainActivity
import com.example.lesson2.mvpuser.UserPresenter
import com.example.lesson2.mvpusers.UsersPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        CiceroneModule::class,
        RepositoryModule::class,
        RoomModule::class
    ])
interface ApplicationComponent {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: UsersPresenter)
    fun inject(activity: UserPresenter)
}