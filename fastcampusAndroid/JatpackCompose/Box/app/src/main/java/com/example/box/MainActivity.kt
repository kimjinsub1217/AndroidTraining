package com.example.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.box.ui.theme.BoxTheme

// Box 는 두가지 용도로 쓰인다.
// 1. Box 자체를 만드는데 사용
// 2. Android FrameLayout 같이 중첩시키는 용도로 사용

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxTheme {
                BoxEx()
            }
        }
    }
}

@Composable
fun BoxEx() {
//    Box(modifier = Modifier.size(100.dp)) {
//        Text(text = "Hello World", modifier = Modifier.align(Alignment.TopStart))
//    }

//     스텝 1 : Text 두개를 Box 안에 배치한다.
//    Box(modifier = Modifier.size(100.dp)) {
//        Text(text = "Hello World", modifier = Modifier.align(Alignment.TopStart))
//        Text(text = "Jetpack", modifier = Modifier.align(Alignment.CenterStart))
//        Text(text = "Compose", modifier = Modifier.align(Alignment.BottomStart))
//    }

    // 스텝 2 : 2개의 Box를 Box 안에 배치하고 사이즈를 70dp, 색상을 각기 다르게 해본다.
//    Box(modifier = Modifier.size(100.dp)) {
//        Box(modifier = Modifier.size(70.dp).background(Color.Magenta).align(Alignment.CenterStart))
//        Box(modifier = Modifier.size(70.dp).background(Color.LightGray).align(Alignment.BottomEnd))
//    }

    // 스텝 3 :  부모 Box에 mpdifier 설정을 제거해서 콘텐트 사이즈만큼 보여진다.
    // 첫번째 자식 Box의 사이즈를 matchParentSize()로 설정한다.
    // 다음에는 fillMaxsize()를 설정한다.
    Box {
        Box(modifier = Modifier.fillMaxSize().background(Color.Magenta).align(Alignment.CenterStart))
        Box(modifier = Modifier.size(70.dp).background(Color.Green).align(Alignment.Center))
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreView() {
    BoxTheme {
        BoxEx()
    }
}