package com.example.t2.di_problem.uncertain_lifetime2.abc.di

import com.example.t2.di_problem.uncertain_lifetime2.CustomCompScope
import com.example.t2.di_problem.uncertain_lifetime2.abc.C
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject2
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ABC_Module::class])
@CustomCompScope
interface ABC_Component{

    fun c(): C
    @Component.Builder
    interface Builder{
        @BindsInstance fun setSO(i:SystemObject2):Builder
        fun build():ABC_Component
    }
}