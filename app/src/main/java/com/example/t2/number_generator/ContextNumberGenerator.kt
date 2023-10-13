package com.example.t2.number_generator

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.t2.act_provider.CurrentActProvider
import dagger.Lazy
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

/**
 * Some class that require activity context.
 */
class ContextNumberGenerator @Inject constructor(
    val currentActProvider: CurrentActProvider,
):NumberGenerator{
    val n: MutableState<Int> = mutableStateOf(0)
    val context:Activity? get()=currentActProvider.currentAct
    override fun generateNumber() {
        val randomNum = (1 .. 1000).random() + (context?.hashCode()?:-1)
        n.value = randomNum
    }

    override val currentNumber: Int
        get() = n.value

    override val currentNumberWithDecoration: String
        get() = "++ ${(context?.hashCode()?:-1)/2} ++"

    override val id: Int = (1..100).random()
}