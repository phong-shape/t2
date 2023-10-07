package com.example.t2.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.t2.number_generator.NumberGenerator

@Composable
fun NumberGeneratorView(
    numberGenerator: NumberGenerator,
    modifier: Modifier = Modifier
) {
    val text by remember {
        derivedStateOf {
            numberGenerator.currentNumberWithDecoration
        }
    }
    Row(
        modifier = modifier
            .padding(8.dp)
            .height(50.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(end = 10.dp)
                .weight(1f)
                .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(13.dp))
                .fillMaxHeight()
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxSize(),
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                ),
            )
        }

        RunButton(onClick = {
            numberGenerator.generateNumber()
        })
    }
}

