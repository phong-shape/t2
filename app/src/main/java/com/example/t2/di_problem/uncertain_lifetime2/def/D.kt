package com.example.t2.di_problem.uncertain_lifetime2.def

/**
 * One solution: Dagger Component.
 *
 * Have to declare:
 * - A Dagger component: with a custom scope to constraint objects in a custom scope
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
 * - Anything from the system must be provided manually to the Dagger builder via the bridge object. However, at least, everything is in one place.
 * - Don't use this, use hilt custom component instead.
 *
 */


interface D