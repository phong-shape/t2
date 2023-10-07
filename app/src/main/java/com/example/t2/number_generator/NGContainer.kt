package com.example.t2.number_generator

/**
 * Just contain a list of [NumberGenerator].
 */
interface NGContainer {
    val generators: List<NumberGenerator>
    fun addGenerator(i:NumberGenerator)
}