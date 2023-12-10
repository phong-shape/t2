package com.example.t2.di_problem.uncertain_lifetime2.abc

import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject1
import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject2
import javax.inject.Inject

class C @Inject constructor(
    val b: B,
    val a: A,
    val so1: SystemObject1,
    val so2: SystemObject2
)