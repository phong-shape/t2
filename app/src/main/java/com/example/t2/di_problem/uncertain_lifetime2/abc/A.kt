package com.example.t2.di_problem.uncertain_lifetime2.abc

import com.example.t2.di_problem.uncertain_lifetime2.def.di.DEF_DaggerComponent

/**
 * Give A, B, C:
 *  - A
 *  - B(A)
 *  - C(B,A)
 * Constraint:
 *  - A must be the same for B and C
 *  - C need access to system object
 *
 *  I don't need to repeat what I did to F here with C, because C is simply a part of F, so C can use F's graph (represented by [DEF_DaggerComponent].
 *
 *  So, to provide external dependencies to C, just append them to [F_FactoryImp]
 */

interface A