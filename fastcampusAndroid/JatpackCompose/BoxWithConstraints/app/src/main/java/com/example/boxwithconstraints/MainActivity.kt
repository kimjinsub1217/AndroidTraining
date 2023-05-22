package com.example.boxwithconstraints

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.boxwithconstraints.ui.theme.BoxWithConstraintsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxWithConstraintsTheme {
                Outer()
            }
        }
    }
}

@Composable
fun Outer() {
    // 스텝 4 : Column에 width를 지정해서 제한한다.
    Column {
        // 스텝 2 : Inner의 인자로 Modifier.widthIn(min = 100.dp)를 전달한다.
        // heightIn도 전잘한다, 각각 인자의 max 값도 전달한다.

        Inner(
            modifier = Modifier
                .widthIn(min = 50.dp)
                .heightIn(min = 50.dp, max = 100.dp)
        )
    }
}

// 스텝 1 : Inner 인자로 modifier를 전달한다.
// 기본 값을 Modifier로 지정하고 파라미터로 받은 modifier를 BoxWithConstrains에 전달한다
@Composable
private fun Inner(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier) {
        // 스텝 3 : maxHeight 값이 150dp가 넘을 때만 추가로 텍스트를 출력한다.
        if (maxHeight > 48.dp) {
            Text(
                text = "길어요~",
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
        Text("maxW: $maxWidth maxH : $maxHeight minW: $minWidth minH:$minHeight")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BoxWithConstraintsTheme {
        Outer()
    }
}