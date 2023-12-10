package com.example.t2.di_problem.uncertain_lifetime2

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton

@Scope
annotation class CustomCompScope

/**
 * Definintion:
 *  - System components: SingletonComponent, ActivityComponent, etc
 *  -
 */

/**
 * The problem:
 *
 * Given D, E, F
 * - E(D) : E depends on D
 * - F(D,E): F depends on D and E
 *
 * Requirement:
 * - D must be the same for both E and F.
 * - F must be scope-less
 *
 * One example of this behavior is: navigation presenter creator in login flow
 *
 * example: OKConfig.createLoginUserComponent()
 *      -> this function creates a LoginUserComponent that can launch an entire login flow.
 *      -> The navigation presenter is shared by almost all children objects of LoginUserComponent
 */

/**
 * One solution: Dagger Component.
 *
 * Have to declare:
 * - A Dagger component: with a custom scope
 * - A Dagger component builder (the Dagger builder): to inject external dependencies into this component.
 * - A singleton bridge object to tap into System components:
 *      - This object provide the Dagger builder with everything it needs from the system.
 *      - this object can:
 *          - create the Dagger component by invoking the Dagger builder
 *          - call the Dagger component to create whatever it needs
 *      - this object is:
 *          - a singleton in whatever system scope we need
 *
 * Strength:
 * - can inject freely
 * - Can access all the system component using the bridge object.
 *
 * Weakness:
 * - Anything from the system must be provided manually to the Dagger builder via the bridge object.
 *
 * Discussion:
 * - if I attach the dagger component to the system component, it becomes a pointless abstraction layer, because I can just simply use the system component directly.
 */


interface D {
    fun d1(): String
    fun d2(): String
}


class DImp @Inject constructor() : D {
    override fun d1(): String {
        val rt = "d1: ${this}"
        return rt
    }

    override fun d2(): String {
        val rt = "d2: ${this}"
        return rt
    }
}

/**
 * Scopeless
 */
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

/**
 * Scopeless
 */
class F @Inject constructor(
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


@Module
@DisableInstallInCheck
interface LocalModule {
    @Binds
    @CustomCompScope
    fun d(i: DImp): D
}

/**
 * The point of this component to create a place/scope to house object of a custom scope ([CustomCompScope]).
 */
@Component(modules = [LocalModule::class])
@CustomCompScope
interface DaggerComponent {
    fun f(): F
    fun e(): E
    fun d(): D

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setSO(i: SystemObject): Builder
        fun build(): DaggerComponent
    }
}

/**
 * A singleton factory to create [DaggerComponent]
 */
interface BridgeObject {
    fun makeF():F
}

/**
 * A singleton factory to create [DaggerComponent]
 */
class BridgeObjectImp @Inject constructor(
    private val sysObject: SystemObject
) : BridgeObject {
    override fun makeF(): F {
        val builder = DaggerDaggerComponent
            .builder()
            .setSO(sysObject)
        val rt = builder.build()
        return rt.f()
    }
}

/**
 * A module attached to a system component, in this case [SingletonComponent]
 */
@Module
@InstallIn(SingletonComponent::class)
interface SystemModule {
    @Binds
    @Singleton
    fun so(i: SystemObjectImp): SystemObject

    /**
     * Bridge object bins to [SingletonComponent]
     */
    @Binds
    @Singleton
    fun compFactory(i: BridgeObjectImp): BridgeObject
}

/**
 * Some singleton object from System's component
 */
interface SystemObject {
    fun doWork1()
    fun doWork2()
}

/**
 * Some singleton System object
 */
class SystemObjectImp @Inject constructor(
    @ApplicationContext
    val context: Context
) : SystemObject {
    override fun doWork1() {
        println("run SystemObject.doWork1")
    }

    override fun doWork2() {
        println("run SystemObject.doWork2")
    }
}