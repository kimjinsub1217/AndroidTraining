package com.example.row

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.row.ui.theme.RowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowTheme {
                RowEx()
            }
        }
    }
}

//Row : 가로로 배치한다.
@Composable
fun RowEx() {
//    Row(modifier = Modifier.height(40.dp)) {
//        Text(text = "1 번")
//        Text(text = "2 번")
//        Text(text = "3 번")
//    }

    // 스텝 1 :  각 Text의 modifier에 align을 설정한다.
    // Alignment.top , CenterVertically, Bottom 지정한다.
    // align() : 세로로 셋팅한다.
//    Row(modifier = Modifier.height(40.dp)) {
//        Text(text = "1 번", modifier = Modifier.align(Alignment.Top))
//        Text(text = "2 번", modifier = Modifier.align(Alignment.CenterVertically))
//        Text(text = "3 번", modifier = Modifier.align(Alignment.Bottom))
//    }

    // 스텝 2 : Row에 vertivalAlignment를 설정한다.
    // Text에 align을 사용할 떄와 쓰이는 값이 같다.
//    Row(
//        modifier = Modifier.height(40.dp),
//        verticalAlignment = Alignment.Bottom
//    ) {
//        Text(text = "1 번", modifier = Modifier.align(Alignment.Top))
//        Text(text = "2 번")
//        Text(text = "3 번")
//    }

    // 스텝 3 : Row의 width를 200dp으로 설정
    // Row에 horizontalArrangement에 Arrangment.Center를
    // 설정한다. Start, End, SpaceAround, SpaceBetween, SpaceEvenly를 설정

//    Row(
//        modifier = Modifier
//            .height(40.dp)
//            .width(200.dp),
//        verticalAlignment = Alignment.Bottom,
//        horizontalArrangement = Arrangement.Center
//    ) {
//        Text(text = "1 번", modifier = Modifier.align(Alignment.Top))
//        Text(text = "2 번")
//        Text(text = "3 번")
//    }

    // 스텝 4 : horizontalArrangement를 제거하고 각 Text에
    // Modifier.weight를 설정한다. 각 항목의 weight 값을 바꾸어 본다.
//    Row(
//        modifier = Modifier
//            .height(40.dp)
//            .width(200.dp),
//        verticalAlignment = Alignment.Bottom,
//    ) {
//        Text(
//            text = "1 번",
//            modifier = Modifier
//                .align(Alignment.Top)
//                .weight(3f)
//
//        )
//        Text(
//            text = "2 번",
//            modifier = Modifier.weight(2f)
//        )
//        Text(
//            text = "3 번",
//            modifier = Modifier.weight(3f)
//        )
//    }

    // 스텝 5 : Text 대신 Icon을 하나 넣는다.
    Row(
        modifier = Modifier
            .height(40.dp)
            .width(200.dp),
        verticalAlignment = Alignment.Bottom,
    ) {
        Text(
            text = "1 번",
            modifier = Modifier
                .align(Alignment.Top)
                .weight(3f),
            textAlign = TextAlign.End

        )
       Icon(
           imageVector = Icons.Filled.Add,
           contentDescription = "추가",
           modifier = Modifier.weight(1f)
               .background(Color.Cyan)
       )
        Text(
            text = "3 번",
            modifier = Modifier.weight(3f)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RowTheme {
        RowEx()
    }
}