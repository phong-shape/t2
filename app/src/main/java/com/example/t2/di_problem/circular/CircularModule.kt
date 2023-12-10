package com.example.t2.di_problem.circular

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CircularModule {
    @Binds
    @Singleton
    fun a(i: AImp): A

    @Binds
    @Singleton
    fun b(i: BImp): B

}