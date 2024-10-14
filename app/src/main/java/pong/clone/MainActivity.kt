package pong.clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pong.clone.ui.theme.PongCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PongCloneTheme {
                Lol()
            }
        }
    }
}


@Composable
fun Lol() {
    Column(modifier = Modifier.fillMaxSize().border(3.dp,Color.White, shape = RoundedCornerShape(40.dp))){
        Canvas(modifier = Modifier.fillMaxSize().background(Color.Black)){
            val canvasWidth = size.width
            val canvasHeight = size.height
            val ballOffset = 72
            println("Canvas size = $size")
            drawCircle(Color.Green, 50f, center = Offset(canvasWidth-ballOffset, canvasHeight-ballOffset))
        }
    }
}