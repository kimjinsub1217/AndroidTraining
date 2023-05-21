package com.example.column

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.column.ui.theme.ColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnTheme {
                ColumnEx()
            }
        }
    }
}

@Composable
fun ColumnEx() {
//    Column(modifier = Modifier.size(100.dp)) {
//        Text(text="1 번")
//        Text(text="2 번")
//        Text(text="3 번")
//    }

    // 스텝 1 : horizontalAlignment를 Column에 적용한다.
    // Alignment : 레이아웃의 반대로 진행됨 즉,가로로 진행이됨
//    Column(
//        modifier = Modifier.size(100.dp),
//        horizontalAlignment = Alignment.End
//    ) {
//        Text(text = "1 번")
//        Text(text = "2 번")
//        Text(text = "3 번")
//    }

    // 스텝 2 : Column에 verticalArrangement를 지정한다.
    // Arrangement : 진행 방향으로 이루어짐
    // SpaceAround, SpaceEvenly, SpaceBetween를 사용해 본다.
//    Column(
//        modifier = Modifier.size(100.dp),
//        horizontalAlignment = Alignment.End,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(text = "1 번")
//        Text(text = "2 번")
//        Text(text = "3 번")
//    }

    // 스텝 3 : Text에 Modifier.align을 사용해 본다.
    Column(
        modifier = Modifier.size(100.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "1 번",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(text = "2 번")
        Text(
            text = "3 번",
            modifier = Modifier.align(Alignment.Start)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColumnTheme {
        ColumnEx()
    }
}