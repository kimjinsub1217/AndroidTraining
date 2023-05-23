package com.example.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import com.example.image.ui.theme.ImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    // 스텝 1 : Image를 만든다.
    Image(
        painter = painterResource(id =R.drawable.a1 ),
        contentDescription = "귀멸의 칼날 무이치로"
    )

    // 스텝 2 : 두 번째 Image를 만든다.
    Image(
        imageVector = Icons.Filled.Search,
        contentDescription = ""
    )
    
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImageTheme {
        Greeting()
    }
}