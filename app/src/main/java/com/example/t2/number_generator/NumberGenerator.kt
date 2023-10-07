package com.example.t2.number_generator

/**
 * Make:
 * - a random generator
 * - an even generator
 * - an odd generator
 * - a decorator generator with custom label that can be specified at runtime
 *      - this decorator can be reused by other existin generator to add decoration to numbers.
 */
interface NumberGenerator {
    fun generateNumber()
    val currentNumber:Int
    val currentNumberWithDecoration:String
    val id:Int
}