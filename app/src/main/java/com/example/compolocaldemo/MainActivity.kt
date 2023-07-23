package com.example.compolocaldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.compolocaldemo.ui.theme.CompoLocalDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompoLocalDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}



@Composable
fun Composable1() {
    val LocalColor = compositionLocalOf { Color.Red }
    val color = Color.Blue

    CompositionLocalProvider(LocalColor provides color) {
        Composable5()
    }


    Column {
        Composable2()
        Composable3()
    }
}

@Composable
fun Composable2() {
    Composable4()
}

@Composable
fun Composable3() {
    Composable5()
}

@Composable
fun Composable4() {
    Composable6()
}

@Composable
fun Composable5() {

    Composable7()
    Composable8()
}

@Composable
fun Composable6() {
    Text(text = "Composable 6")
}

@Composable
fun Composable7() {

}

@Composable
fun Composable8() {

    Text(text = "Composable 8")
}
