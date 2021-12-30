package com.example.lesson2.di

import com.example.lesson2.mvpuser.di.UserComponent
import dagger.Module


@Module(subcomponents = [UserComponent::class])
class AppModule() {

}