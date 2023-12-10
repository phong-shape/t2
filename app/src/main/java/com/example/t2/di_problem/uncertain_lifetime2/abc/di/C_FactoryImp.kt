package com.example.t2.di_problem.uncertain_lifetime2.abc.di

import com.example.t2.di_problem.uncertain_lifetime2.abc.C
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject2
import javax.inject.Inject

/**
 * Bridge object
 */
class C_FactoryImp @Inject constructor(
    val so:SystemObject2
) : C_Factory {
    override fun makeC(): C {
        val comp = DaggerABC_Component
            .builder()
            .setSO(so)
            .build()

        val rt = comp.c()
        return rt
    }
}