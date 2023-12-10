package com.example.t2.di_problem.uncertain_lifetime2.from_system.di

import com.example.t2.di_problem.uncertain_lifetime2.abc.di.C_Factory
import com.example.t2.di_problem.uncertain_lifetime2.abc.di.C_FactoryImp
import com.example.t2.di_problem.uncertain_lifetime2.def.di.F_Factory
import com.example.t2.di_problem.uncertain_lifetime2.def.di.F_FactoryImp
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject1
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject1Imp
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject2
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject2Imp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * A module attached to a system component, in this case [SingletonComponent]
 */
@Module
@InstallIn(SingletonComponent::class)
interface SystemModule_Singleton {

    @Binds
    @Singleton
    fun so2(i: SystemObject2Imp): SystemObject2

    @Binds
    @Singleton
    fun so(i: SystemObject1Imp): SystemObject1

    /**
     * Bridge object bins to [SingletonComponent]
     */
    @Binds
    @Singleton
    fun compFactory(i: F_FactoryImp): F_Factory

    @Binds
    @Singleton
    fun cFactory(i: C_FactoryImp):C_Factory
}