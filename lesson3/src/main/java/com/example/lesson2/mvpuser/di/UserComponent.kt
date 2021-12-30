package com.example.lesson2.mvpuser.di

import com.example.lesson2.mvpuser.UserPresenter
import dagger.Subcomponent
import javax.inject.Scope

@FragmentScope
@Subcomponent(
    modules = [AllDependenciesModule::class]
)
interface UserComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserComponent
    }

    fun inject(activity: UserPresenter)
}

@Scope
annotation class FragmentScope