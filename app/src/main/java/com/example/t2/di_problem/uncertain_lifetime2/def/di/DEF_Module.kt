package com.example.t2.di_problem.uncertain_lifetime2.def.di

import com.example.t2.di_problem.uncertain_lifetime2.CustomCompScope
import com.example.t2.di_problem.uncertain_lifetime2.def.D
import com.example.t2.di_problem.uncertain_lifetime2.def.DImp
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

/**
 * Definintion:
 *  - System components: SingletonComponent, ActivityComponent, etc
 */

@Module
@DisableInstallInCheck
interface DEF_Module {
    @Binds
    @CustomCompScope
    fun d(i: DImp): D
}

