package com.example.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.constraintlayout.ui.theme.ConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintLayoutEx()
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutEx() {

    val constraintSet = ConstraintSet {
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")

        constrain(redBox) {
            bottom.linkTo(parent.bottom, margin = 8.dp)
            end.linkTo(parent.end, margin = 4.dp)
        }

        constrain(magentaBox) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(greenBox) {
            centerTo(parent)
        }
        constrain(yellowBox) {
            start.linkTo(magentaBox.end)
            top.linkTo(magentaBox.bottom)
        }
    }


    ConstraintLayout(constraintSet, modifier = Modifier.fillMaxSize()) {

//        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        Box(

            modifier = Modifier
                .size(40.dp)
                .background(androidx.compose.ui.graphics.Color.Red)
                .layoutId("redBox")
//                .constrainAs(redBox) {
////                    bottom.linkTo(parent.bottom, margin = 8.dp)
////                    end.linkTo(parent.end, margin = 4.dp)
//                }
        )
        Box(

            modifier = Modifier
                .size(40.dp)
                .background(androidx.compose.ui.graphics.Color.Magenta)
                .layoutId("magentaBox")
//                .constrainAs(magentaBox) {
////                    start.linkTo(parent.start)
////                    end.linkTo(parent.end)
//                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .layoutId("greenBox")
                .background(androidx.compose.ui.graphics.Color.Green)
//                .constrainAs(greenBox) {
////                    start.linkTo(parent.start)
////                    end.linkTo(parent.end)
////                    top.linkTo(parent.top)
////                    bottom.linkTo(parent.bottom)
//
////                    centerTo(parent)
//                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .layoutId("yellowBox")
                .background(androidx.compose.ui.graphics.Color.Yellow)
//                .constrainAs(yellowBox) {
////                    start.linkTo(magentaBox.end)
////                    top.linkTo(magentaBox.bottom)
//                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintLayoutTheme {
        ConstraintLayoutEx()
    }
}