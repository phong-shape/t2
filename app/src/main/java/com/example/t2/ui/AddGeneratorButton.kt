package com.example.t2.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@Composable
fun AddGeneratorButton(
    modifier: Modifier = Modifier,
    text: String = "Add",
    onClick: () -> Unit,
) {

    val big = 105f
    val small = 100f
    val animatedSize = remember { Animatable(small) }
    val cs = rememberCoroutineScope()

    Box(Modifier.size(big.dp), contentAlignment = Alignment.Center) {
        Button(
            onClick = {
                cs.launch {
                    animatedSize.animateTo(big, Utils.shortPulsingSpec)
                    animatedSize.animateTo(small, Utils.shortPulsingSpec)
                }
                onClick()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ),
            shape = CircleShape,
            modifier = modifier.size(animatedSize.value.dp),
            contentPadding = PaddingValues(10.dp)
        ) {
            Text(
                text, style = TextStyle(
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Preview
@Composable
fun Preview_AddGeneratorButton() {
    AddGeneratorButton {

    }
}