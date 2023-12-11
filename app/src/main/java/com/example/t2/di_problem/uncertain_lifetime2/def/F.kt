package com.example.t2.di_problem.uncertain_lifetime2.def

import com.example.t2.di_problem.uncertain_lifetime2.abc.C
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject1
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject2
import javax.inject.Inject

/**
 * Scopeless
 */
class F @Inject constructor(
    val d: D,
    val e: E,
    val c: C,
    val so1:SystemObject1,
)