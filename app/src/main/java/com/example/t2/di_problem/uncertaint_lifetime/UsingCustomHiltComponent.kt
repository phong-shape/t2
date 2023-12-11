package com.example.t2.di_problem.uncertaint_lifetime

import android.content.Context
import com.example.t2.di.EvenGenerator
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject1
import com.example.t2.number_generator.NumberGenerator
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Scope

@Scope
annotation class CustomCompScope


@CustomCompScope
class D2 @Inject constructor()

class E2 @Inject constructor(
    val d: D2
)

class F2 @Inject constructor(
    val d: D2,
    val e: E2,
    val contextAccessor: ContextAccessor,
)



@ActivityScoped
class ContextAccessor @Inject constructor(
    @ApplicationContext val context: Context,
    @ActivityContext val actContext:Context,
    @EvenGenerator
    val generator3: NumberGenerator,
)



/**
 * Custom Hilt Component
 * Have to declare:
 *  - An empty custom component: can only access SingletonComponent
 *  - A component builder: this one is available globally as a singleton
 *  - An entry point to access exclusively the objects inside the custom component
 *         -> but we can do it better here, by making a wrapper to encapsulate and hide away all the entrypoint logic
 *         -> see [CustomHiltComponent_Accessor] below
 * Strength:
 *  - Can access everything in the parent's component, everything is injected automatically, no need to do anything manually except creating the entry point.
 */


@DefineComponent(parent = ActivityComponent::class)
@CustomCompScope
interface CustomHiltComponent

@DefineComponent.Builder
interface CustomHiltComponent_Builder {
    fun build(): CustomHiltComponent
}

@EntryPoint
@InstallIn(CustomHiltComponent::class)
interface CustomHiltComponent_EntryPoint {
    fun getF(): F2
}


class CustomHiltComponent_Accessor @Inject constructor(
    val builder: CustomHiltComponent_Builder
){
    val comp = builder.build()
    val entryPoint = EntryPoints.get(comp,CustomHiltComponent_EntryPoint::class.java)
    fun getF():F2{
        return entryPoint.getF()
    }
}