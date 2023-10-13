package com.example.t2.number_generator

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import javax.inject.Inject

class RandomGenerator2 (val limit: Int) : NumberGenerator {
    val n: MutableState<Int> = mutableStateOf(0)
    override fun generateNumber() {
        val randomNum = ((limit-1000)..limit).random()
        n.value = randomNum
    }

    override val currentNumber: Int
        get() = n.value

    override val currentNumberWithDecoration: String
        get() = ">> $currentNumber <<"

    override val id: Int = (1..100).random()
}