package com.example.t2.act_provider

import android.app.Activity
import android.os.Bundle
import javax.inject.Inject

class CurrentActProviderImp @Inject constructor():CurrentActProvider{

    var _act: Activity? = null
        @Synchronized get
        @Synchronized set

    override val currentAct get() = _act
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        _act = activity
    }

    override fun onActivityStarted(activity: Activity) {
        _act = activity
    }

    override fun onActivityResumed(activity: Activity) {
        _act = activity
    }

    override fun onActivityPaused(activity: Activity) {
        // I could be wrong here
        _act = activity
    }

    override fun onActivityStopped(activity: Activity) {
        // I could be wrong here
        _act = null
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        // I could be wrong here
        _act = null
    }

    override fun onActivityDestroyed(activity: Activity) {
        _act = null
    }

}