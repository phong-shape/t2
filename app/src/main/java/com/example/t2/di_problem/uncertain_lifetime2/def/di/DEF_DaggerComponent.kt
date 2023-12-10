package com.example.t2.di_problem.uncertain_lifetime2.def.di

import com.example.t2.di_problem.uncertain_lifetime2.CustomCompScope
import com.example.t2.di_problem.uncertain_lifetime2.abc.C
import com.example.t2.di_problem.uncertain_lifetime2.abc.di.C_Factory
import com.example.t2.di_problem.uncertain_lifetime2.def.D
import com.example.t2.di_problem.uncertain_lifetime2.def.E
import com.example.t2.di_problem.uncertain_lifetime2.def.F
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject1
import dagger.BindsInstance
import dagger.Component

/**
 * The point of this component to create a place/scope to house object of a custom scope ([CustomCompScope]).
 */
@Component(modules = [DEF_Module::class])
@CustomCompScope
interface DEF_DaggerComponent {
    fun f(): F
    fun e(): E
    fun d(): D

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setSO(i: SystemObject1): Builder
        @BindsInstance
        fun setC(i: C):Builder
        fun build(): DEF_DaggerComponent
    }
}