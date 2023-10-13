package com.example.t2

import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import com.example.t2.act_provider.CurrentActProvider
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {
    @Inject
    lateinit var currentActProvider:CurrentActProvider
    override fun onCreate() {
        super.onCreate()
        this.registerActivityLifecycleCallbacks(currentActProvider)

    }
}