package com.example.t2.number_generator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

class BasicGenerator : NumberGenerator {

    val c = mutableStateOf(0)

    override fun generateNumber() {
        c.value = (1..100).random()
    }

    override val currentNumber: Int by c

    override val currentNumberWithDecoration: String
        get() = currentNumber.toString()

    override val id: Int
        get() = 1
}