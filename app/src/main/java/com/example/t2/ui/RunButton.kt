package com.example.t2.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun RunButton(
    onClick: () -> Unit
) {
    val big = 1.3f
    val small = 1f
    val animatedScale = remember { Animatable(small) }
    val cs = rememberCoroutineScope()
    Button(
        onClick = {
            cs.launch {
                animatedScale.animateTo(big, Utils.longPulsingSpec)
                animatedScale.animateTo(small, Utils.longPulsingSpec)
            }
            onClick()
        },
        Modifier.size(width = 80.dp, height = 50.dp).scale(animatedScale.value),
        shape = RoundedCornerShape(13.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xffeaba22)
        )
    ) {
        Text(text = "R",style= TextStyle(fontSize = 30.sp,color=Color.White))
    }
}

@Preview
@Composable
fun Preview_RunButton() {
    RunButton {

    }
}