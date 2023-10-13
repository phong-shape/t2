package com.example.t2.number_generator

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import javax.inject.Inject

class OddNumberGenerator constructor(
    val f:Float
) : NumberGenerator {
    val n: MutableState<Int> = mutableStateOf(0)
    override fun generateNumber() {
        val randomNum = (1 .. 1000).random()
        if(randomNum%2!=0){
            n.value = -randomNum
        }else{
            n.value = -(randomNum+1)
        }
    }

    override val currentNumber: Int
        get() = n.value
    override val currentNumberWithDecoration: String
        get() = "^^${currentNumber}^^"
    override val id: Int = (1 .. 100) .random()
}