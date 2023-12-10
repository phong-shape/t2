package com.example.t2.di_problem.circular

import dagger.Lazy
import javax.inject.Inject


class BImp @Inject constructor(val a:Lazy <A>): B {

//    init{
//        println(a.get().toString())
//    }

    override val b: Int
        get() = a.get().a*100
    override val b2: Int
        get() = -1
}