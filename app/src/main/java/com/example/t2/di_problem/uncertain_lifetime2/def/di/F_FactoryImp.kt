package com.example.t2.di_problem.uncertain_lifetime2.def.di

import com.example.t2.di_problem.uncertain_lifetime2.def.F
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject1
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject2
import javax.inject.Inject

/**
 * A singleton factory to create [DEF_DaggerComponent].
 * This class is wired to the System's graph, so it can access everything in the app.
 */
class F_FactoryImp @Inject constructor(
    private val sysObject1: SystemObject1, // C & F need this
    private val sysObject2:SystemObject2, // C & F need this
) : F_Factory {
    override fun makeF(): F {
        val builder = DaggerDEF_DaggerComponent.builder()
            .setSO1(sysObject1)
            .setSO2(sysObject2)
        val rt = builder.build()
        return rt.f()
    }
}