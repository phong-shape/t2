package com.example.t2.di_problem.uncertain_lifetime2.def.di

import com.example.t2.di_problem.uncertain_lifetime2.abc.di.C_Factory
import com.example.t2.di_problem.uncertain_lifetime2.def.F
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject1
import javax.inject.Inject

/**
 * A singleton factory to create [DEF_DaggerComponent]
 */
class F_FactoryImp @Inject constructor(
    private val sysObject: SystemObject1,
    private val c_factory:C_Factory,
) : F_Factory {
    override fun makeF(): F {
        val builder = DaggerDEF_DaggerComponent.builder()
            .setSO(sysObject)
            .setC(c_factory.makeC())
        val rt = builder.build()
        return rt.f()
    }
}