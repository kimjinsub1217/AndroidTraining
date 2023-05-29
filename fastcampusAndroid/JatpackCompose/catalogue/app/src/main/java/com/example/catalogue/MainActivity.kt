package com.example.catalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catalogue.ui.theme.CatalogueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogueTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    CatalogEx(items)
                }
            }
        }
    }
}

@Composable
fun Item(itemData: ItemData) {

    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = itemData.imageId),
                contentDescription = itemData.title,
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = itemData.title,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = itemData.description)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    CatalogueTheme {
        Item(
            ItemData(
                imageId = R.drawable.a1,
                title = "뉴진스",
                description = "2022년 7월 22일에 데뷔한 ADOR 소속의 5인조 다국적 걸그룹이다."
            )
        )
    }
}

// LazyColumn : 필요할 때만 세로 방향으로 보여진다.
// 안드로이드 recyclerView, liseView를 대처하기 위함이다.
@Composable
fun CatalogEx(itemList: List<ItemData>) {
    LazyColumn {
        items(itemList){ item ->
            Item(item)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CatalogueTheme {
        CatalogEx(items)
    }
}

data class ItemData(
    @DrawableRes val imageId: Int,
    val title: String,
    val description: String,
)

val items = listOf(
    ItemData(
        imageId = R.drawable.a1,
        title = "뉴진스",
        description = "2022년 7월 22일에 데뷔한 ADOR 소속의 5인조 다국적 걸그룹이다."
    ),
    ItemData(
        imageId = R.drawable.a2,
        title = "민지",
        description = "뉴진스 멤버로 국적은 대한민국이고 출생은 2004. 05. 07 이다."
    ),
    ItemData(
        imageId = R.drawable.a3,
        title = "하니",
        description = "뉴진스 멤버로 국적은 호주, 베트남 복수국적이고 출생은 2004. 10. 06 이다."
    ),
    ItemData(
        imageId = R.drawable.a4,
        title = "다니엘",
        description = "뉴진스 멤버로 국적은 호주, 대한민국 복수국적이고 출생은 2005. 04. 11 이다."
    ),
    ItemData(
        imageId = R.drawable.a5,
        title = "해린",
        description = "뉴진스 멤버로 국적은 한국이고 출생은 2006. 05. 15 이다."
    ),
    ItemData(
        imageId = R.drawable.a6,
        title = "혜인",
        description = "뉴진스 멤버로 국적은 한국이고 출생은 2008. 04. 21 이다."
    ),
)