package com.example.t2.di

import android.app.Activity
import android.content.Context
import com.example.t2.number_generator.NumberGenerator
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ActivityComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
interface MyEntryPoint {
    @RandomGenerator2Q
    val generator5: NumberGenerator
    companion object{
        fun entry(act:Activity): MyEntryPoint {
            return EntryPointAccessors.fromActivity(act,MyEntryPoint::class.java)
        }
    }
}