package com.example.t2.di_problem.uncertain_lifetime2.abc

import com.example.t2.di_problem.uncertain_lifetime2.from_system.SystemObject1
import javax.inject.Inject

class B @Inject constructor(
    val a: A,
    val so1:SystemObject1,
)