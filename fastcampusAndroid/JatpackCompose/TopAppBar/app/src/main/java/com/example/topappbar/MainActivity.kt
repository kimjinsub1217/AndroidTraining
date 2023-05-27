package com.example.topappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.topappbar.ui.theme.TopAppBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopBarEx("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarEx(name: String) {
    Column {
        // 스텝 1: TopAppBar를 만들고 title 항목을 채워봅시다.
//        TopAppBar(
//            title = {
//                Text(
//                    "앱바",// 표시할 텍스트
//                    maxLines = 1,// 최대 줄 수 (1줄로 제한)
//                    overflow = TextOverflow.Ellipsis,// 텍스트가 너무 길 경우 생략 부호(...)로 표시
//                    color = Color.Black// 텍스트 색상 (검정색)
//                )
//            },
//            colors = TopAppBarDefaults.smallTopAppBarColors(
//                containerColor = Color.LightGray,// TopAppBar의 배경색을 노란색으로 설정
//            )
//        )
        // 스텝 2: navigationIcon 파라미터를 채워봅시다.
        // IconButton을 만들고 자식으로 Icon을 넣읍시다.
        // 아이콘은 Icons.Filled.ArrowBack을 채웁시다.
        // onClick은 비워둡시다.

//        TopAppBar(
//            title = {
//                Text(
//                    "앱바",// 표시할 텍스트
//                    maxLines = 1,// 최대 줄 수 (1줄로 제한)
//                    overflow = TextOverflow.Ellipsis,// 텍스트가 너무 길 경우 생략 부호(...)로 표시
//                    color = Color.Black// 텍스트 색상 (검정색)
//                )
//            },
//            colors = TopAppBarDefaults.smallTopAppBarColors(
//                containerColor = Color.LightGray,// TopAppBar의 배경색을 노란색으로 설정
//            ),
//            navigationIcon = {
//                IconButton(onClick = {}) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = "업 네비게이션"
//                    )
//                }
//            }
//        )

        // 스텝 3: actions를 추가해봅시다.
        // Icons.Filled의 여러 아이콘을 이용해봅시다.

        TopAppBar(
            title = {
                Text(
                    "앱바",// 표시할 텍스트
                    maxLines = 1,// 최대 줄 수 (1줄로 제한)
                    overflow = TextOverflow.Ellipsis,// 텍스트가 너무 길 경우 생략 부호(...)로 표시
                    color = Color.Black// 텍스트 색상 (검정색)
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.LightGray,// TopAppBar의 배경색을 노란색으로 설정
            ),
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "업 네비게이션"
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "검색"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "설정"
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "계정"
                    )
                }
            }
        )
   

        Text(text = "Hello $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TopAppBarTheme {
        TopBarEx("김진섭")
    }
}