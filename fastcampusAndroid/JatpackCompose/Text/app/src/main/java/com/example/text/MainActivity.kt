package com.example.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.text.ui.theme.TextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(text = "Hello $name!")

    // 색상을 지정하기 위해 color 파라미터에 Color.Blue를 전달
//    Text(color = Color.Blue, text = "Hello $name")

    // Color 객체를 이용해서 해쉬값으로 색상을 전달(ARGB 순)
//    Text(color=Color(0xffff9944),text="Hello $name")

    // fontSize 파라미터에 30.sp를 전달한다.
//    Text(color=Color.Green, text="Hello $name",fontSize=50.sp)

    // fontWeight에 FontWeight.Bold를 전달
//    Text(
//        color = Color.Green,
//        text = "Hello $name",
//        fontSize = 50.sp,
//        fontWeight = FontWeight.Bold
//    )
    // fontFamily에 fontFamily.Cursive를 전달
//    Text(
//        color = Color.Green,
//        text = "Hello $name",
//        fontSize = 50.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive
//    )
    // letterSpacing에 2.sp를 지정해본다.
//    Text(
//        color = Color.Green,
//        text = "Hello $name",
//        fontSize = 50.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp
//    )

    // maxLines를 2로 지정하고 문자열을 더 추가해본다
//    Text(
//        color = Color.Green,
//        text = "Hello $name\nHello $name\nHello $name\n",
//        fontSize = 50.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp,
//        maxLines = 2
//    )
    //textDecoration에 TextDecoration.UnderLine를 추가
//    Text(
//        color = Color.Green,
//        text = "Hello $name\nHello $name\nHello $name\n",
//        fontSize = 50.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp,
//        maxLines = 2,
//        textDecoration = TextDecoration.Underline
//    )

//    textAlign을 TextAlign.Center로 지정
    Text(
        modifier = Modifier.width(300.dp),
        color = Color.Green,
        text = "Hello $name\nHello $name\nHello $name\n",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp,
        maxLines = 2,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextTheme {
        Greeting("Android")
    }
}