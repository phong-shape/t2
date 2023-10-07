package com.example.t2.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun NumberText(
    number:Int,
    color:Color = Color.Black,
    size:TextUnit = 30.sp
) {
    Text("$number", style = TextStyle(
        color = color,
        fontSize = size
    ))
}

@Preview
@Composable
fun Preview_NumberText() {
    NumberText(number = 2)
}