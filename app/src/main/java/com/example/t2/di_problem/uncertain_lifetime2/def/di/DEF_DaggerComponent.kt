package com.example.t2.di_problem.uncertain_lifetime2.def.di

import com.example.t2.di_problem.uncertain_lifetime2.CustomCompScope
import com.example.t2.di_problem.uncertain_lifetime2.abc.di.ABC_Module
import com.example.t2.di_problem.uncertain_lifetime2.def.D
import com.example.t2.di_problem.uncertain_lifetime2.def.E
import com.example.t2.di_problem.uncertain_lifetime2.def.F
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject1
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject2
import dagger.BindsInstance
import dagger.Component

/**
 * The point of this component to create a place/scope to house object of a custom scope ([CustomCompScope]).
 */
@Component(modules = [DEF_Module::class, ABC_Module::class])
@CustomCompScope
interface DEF_DaggerComponent {
    fun f(): F
    fun e(): E
    fun d(): D

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setSO1(i: SystemObject1): Builder

        @BindsInstance
        fun setSO2(i:SystemObject2):Builder


        fun build(): DEF_DaggerComponent
    }
}