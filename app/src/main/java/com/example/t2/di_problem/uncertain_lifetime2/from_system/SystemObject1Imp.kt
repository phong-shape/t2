package com.example.t2.di_problem.uncertain_lifetime2.from_system

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Some singleton System object
 */
class SystemObject1Imp @Inject constructor(
    @ApplicationContext
    val context: Context
) : SystemObject1 {
    override fun doWork1() {
        println("run SystemObject.doWork1")
    }

    override fun doWork2() {
        println("run SystemObject.doWork2")
    }
}