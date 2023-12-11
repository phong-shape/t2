package com.example.t2.di_problem.uncertaint_lifetime

import android.app.Activity
import android.content.Context
import com.example.t2.di.EvenGenerator
import com.example.t2.number_generator.NumberGenerator
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Subcomponent
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton
@Scope
annotation class CustomCompScope



@ActivityScoped
class D @Inject constructor() {
    fun d1(): String {
        val rt = "d1: ${this}"
        return rt
    }

    fun d2(): String {
        val rt = "d2: ${this}"
        return rt
    }
}

class E @Inject constructor(
    val d: D
) {
    fun e1(): String {
        val d1 = d.d1()
        val rt = "e1: ${this} with d1 = ${d1}"
        return rt
    }

    fun e2(): String {
        return "e2"
    }
}

class F_Dagger {
    @Inject
    lateinit var d: D

    @Inject
    lateinit var e: E
    fun f1(): String {
        val d1 = d.d1()
        val rt = "f1: ${this} with d1 = ${d1}"
        return rt
    }

    fun f2(): String {
        val d2 = d.d2()
        val rt = "f2: ${this} with d1 = ${d2}"
        return rt
    }
}

class F_Seq @Inject constructor(
    val d: D,
    val e: E
) {
    fun f1(): String {
        val d1 = d.d1()
        val rt = "f1: ${this} with d1 = ${d1}"
        return rt
    }

    fun f2(): String {
        val d2 = d.d2()
        val rt = "f2: ${this} with d1 = ${d2}"
        return rt
    }
}


/**
 * Dagger Component.
 * Have to declare:
 * - A custom component
 * - A builder: available globally as a singleton
 * - a bridge module to tap into the system DI graph.
 * Strength:
 * - Can inject object freely with inject functions
 * - Can access the system component (SingletonComponent, ActivityComponent, ViewModelComponent, etc) using a bridge module -> this is even worse than using system component.
 * Weakness:
 * - Can't be scoped using custom scopes if attached to system components.
 *
 * Discussion:
 * - if I want to access system components' graph without being scoped to that, I must provide all those dependencies via the dagger component's builder -> well, I can have a wrapper component builder, that has direct access to the system graph, and construct this component using a no-arg function.
 * - if I attach the dagger component to the system component, it becomes a pointless abstraction layer, because I can just simply use the system component directly.
 */


//@CompByDaggerScope
@ActivityScoped
class ContextAccessor @Inject constructor(
    @ApplicationContext val context: Context,
    @ActivityContext val actContext:Context,
    @EvenGenerator
    val generator3: NumberGenerator,
    val f:F_Seq,
    val e:E
)


@Subcomponent
@CustomCompScope
interface CompByDagger {

    val contextAccessor:ContextAccessor

    fun inject(a:Activity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): CompByDagger
    }

    @Module(subcomponents = [CompByDagger::class])
    @InstallIn(ActivityComponent::class)
    interface BridgeModule
}


/**
 * Custom Hilt Component
 * Have to declare:
 *  - An empty custom component: can only access SingletonComponent
 *  - A component builder: this one is available globally as a singleton
 *  - An entry point to access exclusively the objects inside the custom component
 * Weakness:
 *  - Cannot inject object freely
 *  - Cannot access other scopes except SingletonScope (ActivityScope,VMScope)
 *  - Cannot provide to other scopes
 * Strength:
 *  - Can access SingletonScope
 */




@DefineComponent(parent = ActivityComponent::class)
@CustomCompScope
interface SeqComponent

@DefineComponent.Builder
interface SeqCompBuilder {
    fun build(): SeqComponent
}

@EntryPoint
@InstallIn(SeqComponent::class)
interface SeqEntryPoint {
    fun getF(): F_Seq
//    fun getE(): E
}