package com.example.button

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.button.ui.theme.ButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonTheme {
                ButtonExample(onButtonClicked = {
                    // Button 클릭했을 때 Toast를 출력한다.
                    Toast.makeText(this, "Send Clicekd", Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {
    // 1. Button 클릭했을 때 Toast를 출력한다.
//    Button(onClick = onButtonClicked) {
//        Text(text = "Send")
//    }
    // 2.Icon을 Text 앞에 추가한다.
//    Button(onClick = onButtonClicked) {
//        Icon(
//           imageVector = Icons.Filled.Send,
//            contentDescription = "설명을 넣어주는 곳"
//        )
//        Text(text = "Send")
//    }
    // 3. 아이콘과 텍스트 사이에 spacer(간격)를 넣어봅시다.
//    Button(onClick = onButtonClicked) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = "설명을 넣어주는 곳"
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    // 4. enabled를 false로 바꾼다.
//    Button(
//        onClick = onButtonClicked,
//        enabled = false
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = "설명을 넣어주는 곳"
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    //5.border에 BorderStroke를 설정한다.
//    Button(
//        onClick = onButtonClicked,
//        enabled = true,
//        border = BorderStroke(10.dp, Color.Magenta)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = "설명을 넣어주는 곳"
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

    //6. shape를 CircleShape로 지정
//    Button(
//        onClick = onButtonClicked,
//        border = BorderStroke(10.dp, Color.Magenta),
//        shape = RoundedCornerShape(10.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = "설명을 넣어주는 곳"
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Send")
//    }

//    contentPadding에 PaddingValues를 설정한다.
    Button(
        onClick = onButtonClicked,
        border = BorderStroke(10.dp, Color.Magenta),
        contentPadding = PaddingValues(20.dp)

    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = "설명을 넣어주는 곳"
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Send")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ButtonTheme {
        ButtonExample(onButtonClicked = {})
    }
}