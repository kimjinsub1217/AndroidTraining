package com.example.networkimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.networkimage.ui.theme.NetworkImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkImageTheme {
                CoilEx()
            }
        }
    }
}

@Composable
fun CoilEx() {
    // 방법 1: rememberAsyncImagePainter를 이용해 image의 painter를 설정한다.
//    val painter = rememberAsyncImagePainter("https://i.namu.wiki/i/FxhQ3zF1LMHoJlp-1pquZheA413WG2JVRuZbOJixAFJhN8Qycf1xcjfWrDTUoE_-Y0IA06wya5TPqh14WRz3UvLrBmHY493bpgKSOEfqG8uXz2auLEaT5SLOnE6ma3_K6fv3R79YtPLB0Eeniwce3A.webp")
//    Image(
//        painter =painter,
//        contentDescription = "귀멸의 칼날 미츠리"
//    )

    // 방법 2: AsyncImage를 이용한 방법
    AsyncImage(
        model = "https://i.namu.wiki/i/FxhQ3zF1LMHoJlp-1pquZheA413WG2JVRuZbOJixAFJhN8Qycf1xcjfWrDTUoE_-Y0IA06wya5TPqh14WRz3UvLrBmHY493bpgKSOEfqG8uXz2auLEaT5SLOnE6ma3_K6fv3R79YtPLB0Eeniwce3A.webp",
        contentDescription = "귀멸의 칼날 미츠리"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetworkImageTheme {
        CoilEx()
    }
}