package com.example.t2.di

import android.util.Log
import com.example.t2.number_generator.EvenRandomNumberGenerator
import com.example.t2.number_generator.NumberGenerator
import com.example.t2.number_generator.OddNumberGenerator
import com.example.t2.number_generator.RandomGenerator2
import com.example.t2.number_generator.RandomNumberGenerator
import com.example.t2.number_generator.seed.Seed
import com.example.t2.number_generator.seed.SeedImp
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Scope
import javax.inject.Singleton


@Qualifier
annotation class EvenGenerator

@Qualifier
annotation class OddGenerator

@Qualifier
annotation class RandomGenerator2Q

@Module
@InstallIn(ActivityComponent::class)
interface MyModule {

    @Binds
    @ActivityScoped
    fun seed(i:SeedImp):Seed

    @Binds
    @ActivityScoped
    fun randomGenerator(i:RandomNumberGenerator):NumberGenerator

    @Binds
    @EvenGenerator
    @ActivityScoped
    fun evenRandom(i:EvenRandomNumberGenerator):NumberGenerator


    companion object{
        @Provides
        @OddGenerator
        @ActivityScoped
        fun oddRandom():NumberGenerator{
            Log.d("","")
            return OddNumberGenerator(
                123f
            )
        }

        @Provides
        @RandomGenerator2Q
        fun randomeGen2():NumberGenerator{
            return RandomGenerator2(-100)
        }


//        @Provides
//        @ActivityScoped
//        fun randomGenerator(
//            seed:Seed,
//            seed2:Seed,
//        ):NumberGenerator{
//            return RandomNumberGenerator(seed,seed2)
//        }

    }
}