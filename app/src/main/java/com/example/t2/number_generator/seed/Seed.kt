package com.example.t2.number_generator.seed

import javax.inject.Inject

interface Seed {
    val seed:Int
}

class SeedImp (override val seed:Int):Seed{

    @Inject constructor():this(100)

}