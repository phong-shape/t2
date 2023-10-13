package com.example.t2.number_generator

/**
 *
 */
class WeirdNumberGenerator (
    val numberGenerator: NumberGenerator
):NumberGenerator {
    override fun generateNumber() {
        numberGenerator.generateNumber()
    }

    override val currentNumber: Int
        get() = numberGenerator.currentNumber
    override val currentNumberWithDecoration: String
        get() = "weird: ${numberGenerator.currentNumberWithDecoration}"
    override val id: Int
        get() = (1.. 200).random()
}