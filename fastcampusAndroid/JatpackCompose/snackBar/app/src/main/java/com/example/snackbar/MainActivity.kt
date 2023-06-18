package com.example.snackbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.snackbar.ui.theme.SnackBarTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SnackbarEx()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SnackbarEx() {
    var counter by remember { mutableStateOf(0) }

    val coroutineScope = rememberCoroutineScope()



    remember { SnackbarHostState() }
    val scaffoldState = rememberScaffoldState()

    androidx.compose.material.Scaffold(scaffoldState = scaffoldState) {
        Button(onClick = {
            counter++
            coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = "카운터는 ${counter}입니다",
                    actionLabel = "닫기",
                    duration = SnackbarDuration.Short
                )
            }
        }) {
            Text("더하기")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnackBarTheme {
        SnackbarEx()
    }
}