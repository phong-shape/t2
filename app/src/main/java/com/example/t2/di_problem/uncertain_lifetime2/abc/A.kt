package com.example.t2.di_problem.uncertain_lifetime2.abc

/**
 * Give A, B, C:
 *  - A
 *  - B(A)
 *  - C(B,A)
 * Constraint:
 *  - A must be the same for B and C
 *  - C need access to system object -> must use a bridge object
 */

interface A