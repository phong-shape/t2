package com.example.t2.di_problem.circular

import dagger.Lazy
import javax.inject.Inject

class AImp @Inject constructor(val b: Lazy<B>): A {

//    init {
//        println(b.get().toString())
//    }

    override val a: Int
        get() = 100

    override fun printB() {
        println(b.get().b2)
    }

}