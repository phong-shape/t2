package com.example.t2.ui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween

object Utils {
    val shortPulsingSpec = tween<Float>(80, easing = LinearEasing)
    val longPulsingSpec = tween<Float>(160, easing = LinearEasing)
}