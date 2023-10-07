package com.example.t2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.t2.number_generator.BasicGenerator
import com.example.t2.number_generator.NumberGenerator
import com.example.t2.ui.AddGeneratorButton
import com.example.t2.ui.NumberGeneratorView
import com.example.t2.ui.theme.T2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val generator = BasicGenerator()

        setContent {
            T2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White,
                ) {
                    var generators: List<NumberGenerator> by remember {
                        mutableStateOf((1..20).map { generator })
                    }

                    Column(Modifier.fillMaxWidth()) {
                        Column(
                            Modifier
                                .weight(1f)
                                .verticalScroll(rememberScrollState()),
                        ) {
                            for(g in generators){
                                NumberGeneratorView(g)
                            }
                        }

                        Divider(color = MaterialTheme.colorScheme.primary)

                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .padding(top = 7.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            AddGeneratorButton(
                                text = "Odd\n(S)",
                            ) {
                                // add a singleton odd generator
                            }

                            AddGeneratorButton(
                                text = "Even\n(S)",
                            ) {
                                // add a single ton even generator
                            }

                            AddGeneratorButton(
                                text = "Random\n(S)",
                            ) {
                                // add a singleton random generator
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .padding(bottom = 5.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            AddGeneratorButton(
                                text = "Odd\n(N)",
                            ) {
                                // add a new odd generator
                            }

                            AddGeneratorButton(
                                text = "Even\n(N)",
                            ) {
                                // add a new even generator
                            }

                            AddGeneratorButton(
                                text = "Random\n(N)",
                            ) {
                                // add a new random generator
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    T2Theme {
        Greeting("Android")
    }
}