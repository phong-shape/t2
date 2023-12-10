package com.example.t2.di_problem.uncertain_lifetime2.def.di

import com.example.t2.di_problem.uncertain_lifetime2.def.F

/**
 * A singleton factory to create [DEF_DaggerComponent]
 */
interface F_Factory {
    fun makeF(): F
}