package com.example.t2.number_generator

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.t2.number_generator.seed.Seed
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class RandomNumberGenerator @Inject constructor(
    val seed:Seed,
    val seed2:Seed,
) : NumberGenerator {
    private val n : MutableState<Int> = mutableStateOf(-1)

    override fun generateNumber() {
        n.value = (1 .. 1000).random()
    }
    override val currentNumber: Int
        get() = n.value

    override val currentNumberWithDecoration: String
        get() = "** ${currentNumber} **"

    override val id: Int = (1 .. 100).random()
}