package com.example.t2.act_provider.di

import com.example.t2.act_provider.CurrentActProvider
import com.example.t2.act_provider.CurrentActProviderImp
import com.example.t2.number_generator.ContextNumberGenerator
import com.example.t2.number_generator.NumberGenerator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class ContextNumG

@Module
@InstallIn(ActivityRetainedComponent::class) // or any Component
interface ActRetainModule {
    @Binds
    @ContextNumG
    fun contextNumGenerator(i:ContextNumberGenerator):NumberGenerator
}

@Module
@InstallIn(SingletonComponent::class)
interface ActProviderModule {
    /**
     * [CurrentActProvider] is provided in SingletonComponent, as a singleton
     * -> it is available globally
     */
    @Binds
    @Singleton
    fun actProvider(i: CurrentActProviderImp): CurrentActProvider
}