package com.example.t2.ui

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RunButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        Modifier.size(width = 150.dp, height = 100.dp),
        shape = RoundedCornerShape(13.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xff0b6e8a)
        )
    ) {
        Text(text = "Run",style= TextStyle(fontSize = 30.sp,color=Color.White))
    }
}

@Preview
@Composable
fun Preview_RunButton() {
    RunButton {

    }
}