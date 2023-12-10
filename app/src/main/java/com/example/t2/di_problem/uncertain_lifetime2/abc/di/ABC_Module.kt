package com.example.t2.di_problem.uncertain_lifetime2.abc.di

import com.example.t2.di_problem.uncertain_lifetime2.CustomCompScope
import com.example.t2.di_problem.uncertain_lifetime2.abc.A
import com.example.t2.di_problem.uncertain_lifetime2.abc.AImp
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module
@DisableInstallInCheck
interface ABC_Module{
    @Binds
    @CustomCompScope
    fun a(i: AImp): A
}