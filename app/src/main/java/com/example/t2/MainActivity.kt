package com.example.t2

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.t2.act_provider.di.ContextNumG
import com.example.t2.di_problem.circular.A
import com.example.t2.di_problem.circular.B
import com.example.t2.di.EvenGenerator
import com.example.t2.di.OddGenerator
import com.example.t2.di.RandomGenerator2Q
import com.example.t2.di_problem.uncertain_lifetime2.BridgeObject
import com.example.t2.di_problem.uncertaint_lifetime.CompByDagger
import com.example.t2.di_problem.uncertaint_lifetime.ContextAccessor
import com.example.t2.di_problem.uncertaint_lifetime.SeqCompBuilder
import com.example.t2.di_problem.uncertaint_lifetime.SeqEntryPoint
import com.example.t2.number_generator.NumberGenerator
import com.example.t2.ui.theme.T2Theme
import dagger.hilt.EntryPoints
import dagger.hilt.android.AndroidEntryPoint
//import io.heap.autocapture.ViewAutocaptureSDK
//import io.heap.core.Heap
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ContextNumG
    @Inject
    lateinit var cGenerator: NumberGenerator

    @Inject
    lateinit var generator: NumberGenerator

    @Inject
    lateinit var generator2: NumberGenerator

    @Inject
    @EvenGenerator
    lateinit var generator3: NumberGenerator

    @Inject
    @OddGenerator
    lateinit var generator4: NumberGenerator

    @Inject
    @RandomGenerator2Q
    lateinit var generator5: NumberGenerator

    @Inject
    lateinit var a: A

    @Inject
    lateinit var b: B

    @Inject
    lateinit var seqCompBuilder: SeqCompBuilder

    @Inject
    lateinit var daggerCompBuilderProvider:Provider<CompByDagger.Builder>

    @Inject
    lateinit var contextAccessor: ContextAccessor

    @Inject
    lateinit var bridgeObject: BridgeObject

    val seqComp get() = seqCompBuilder.build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uncertainLifetime()
    }

    fun uncertainLifetime(){
        val f = bridgeObject.makeF()
        val e = f.e
        setContent {
            Column {
                Text("f.d == e.d: ${f.d == e.d}")
            }
        }
    }
    fun oldUncertainLifetime(){
        val seqEntryPoint = EntryPoints.get(seqComp, SeqEntryPoint::class.java)
        val b1 = daggerCompBuilderProvider.get()
        val comp = b1.build()
        comp.inject(this)

        val actC = this
        setContent {
            var i by remember{ mutableStateOf(1) }
            Column {
                Button(onClick = { i+=1 }) {
                    Text("${i}")
                }
                Text("app context: ${comp.contextAccessor.context == applicationContext}")
                Text("act context: ${comp.contextAccessor.actContext == actC}")
                Text("context accessor: ${comp.contextAccessor == contextAccessor}")
                Text("generator: ${comp.contextAccessor.generator3 == generator3}")
            }
        }
    }


    private fun setListenersToAllViews(root: View) {
        if(root is ViewGroup){
            for (i in 0 until root.childCount) {
                val child = root.getChildAt(i)
                if (child is ViewGroup) {
                    setListenersToAllViews(child)
                } else {
                    // Example: Set an OnClickListener to each view
                    child.setOnClickListener { v: View? ->
                        println("clickedOn ${v}")
                    }
                }
            }
        }else{
            root.setOnClickListener {
                println("clicked on root")
            }
        }
    }

}

/**
 * Bottomsheet for kimon
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BTS() {
    val state = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val cs = rememberCoroutineScope()
    var s by remember { mutableStateOf(false) }
    if (s) {
        ModalBottomSheet(
            onDismissRequest = {
                s = false
            },
            sheetState = state,
            windowInsets = WindowInsets.navigationBars,
            ) {
            Column(
                Modifier
//                    .fillMaxHeight()
                    .background(Color.Green)

            ) {
                for (x in 1..20) {
                    Text(text = "Item $x")
                }
            }
        }
    }

    Button(
        onClick = {
            cs.launch {
                s = !s
            }
            println("x13q qweqweqweqweqweqw")
        },
        modifier = Modifier.padding(100.dp)
    ) {
        Text("SH")
    }
}

@Composable
fun QWE(i: Int) {
    Text(text = "${i}")
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