package com.example.lesson2.mvpuser.di

import android.content.Context
import com.example.lesson2.mvpuser.GlideWrapper
import dagger.Module
import dagger.Provides

@Module
class AllDependenciesModule {

    @FragmentScope
    @Provides
    fun provideGlideWrapper(context: Context): GlideWrapper {
        return GlideWrapper(context)
    }

}