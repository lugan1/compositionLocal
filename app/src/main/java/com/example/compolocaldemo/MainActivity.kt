package com.example.compolocaldemo

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
                    Composable1()
                }
            }
        }
    }
}

// 상태 전역변수
val LocalColor = compositionLocalOf { Color(0xFFffdbcf) }

@Composable
fun Composable1() {
    // 다크테마인지 아닌지에 따라 컬러 변경
    var color = if(isSystemInDarkTheme()) Color(0xFFa08d87) else Color(0xFFffdbcf)

    Column {
        Composable2()

        // 전역 상태변수 제공
        CompositionLocalProvider(LocalColor provides color){
            Composable3()
        }
    }
}

@Composable
fun Composable2() {
    Composable4()
}

@Composable
fun Composable3() {
    Text(modifier = Modifier.background(LocalColor.current), text = "Composable 3")

    // Composable 5 에 Red 전역 상태 제공
    CompositionLocalProvider(LocalColor provides Color.Red) {
        Composable5()
    }
}

@Composable
fun Composable4() {
    Composable6()
}

@Composable
fun Composable5() {
    Text(modifier = Modifier.background(LocalColor.current), text = "Composable 5")

    // Composable 7 에 Green 전역 상태 제공
    CompositionLocalProvider(LocalColor provides Color.Green) {
        Composable7()
    }

    // Composable 8 에 Yellow 전역 상태 제공
    CompositionLocalProvider(LocalColor provides Color.Yellow) {
        Composable8()
    }
}

@Composable
fun Composable6() {
    // Composable 6 는 2 -> 4 -> 6 트리의 다른 브랜치에 있어서 전역 상태변수에 현재값에 접근할수 없어서 기본값을 사용한다.
    Text(modifier = Modifier.background(LocalColor.current), text = "Composable 6")
}

@Composable
fun Composable7() {
    Text(modifier = Modifier.background(LocalColor.current), text = "Composable 7")
}

@Composable
fun Composable8() {
    Text(modifier = Modifier.background(LocalColor.current), text = "Composable 8")
}


@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DarkPreview() {
    CompoLocalDemoTheme {
        Composable1()
    }
}
