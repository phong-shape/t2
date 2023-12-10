package com.example.t2.di_problem.uncertain_lifetime2.def

import javax.inject.Inject

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
 * Constraint:
 * - Actual life time of D is unknown largely unknown -> can't use system component.
 *
 * One example of this behavior is: navigation presenter creator in login flow
 *
 * example: OKConfig.createLoginUserComponent()
 *      -> this function creates a LoginUserComponent that can launch an entire login flow.
 *      -> The navigation presenter is shared by almost all children objects of LoginUserComponent
 */

class DImp @Inject constructor() : D