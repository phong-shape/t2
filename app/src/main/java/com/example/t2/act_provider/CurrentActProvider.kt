package com.example.t2.act_provider

import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks

/**
 * Provide the current activity
 */
interface CurrentActProvider:ActivityLifecycleCallbacks{
    val currentAct: Activity?
}

