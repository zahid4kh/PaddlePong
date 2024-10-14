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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
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
@Preview
fun Lol() {
    val textMeasurer = rememberTextMeasurer()
    var playerX by remember { mutableFloatStateOf(0f) }
    var playerY by remember { mutableFloatStateOf(0f) }
    var botX by remember { mutableFloatStateOf(0f) }
    var botY by remember { mutableFloatStateOf(0f) }

    //val pause = ImageBitmap.imageResource(id = R.drawable.pause_button)
    val play = ImageBitmap.imageResource(id = R.drawable.play_button)

    Column(modifier = Modifier
        .fillMaxSize()
        .border(3.dp, Color.White, shape = RoundedCornerShape(40.dp))){
        Canvas(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)){
            val canvasWidth = size.width
            val canvasHeight = size.height

            playerX = canvasWidth - 80
            playerY = canvasHeight/2 - 170/2

            botX = 40f
            botY = canvasHeight/2 - 170/2
            //val ballOffset = 72
            drawText(textMeasurer, "Canvas size: ${Pair(canvasWidth, canvasHeight)}", topLeft = Offset(canvasWidth/2.4f, canvasHeight-100))

            drawCircle(Color.White, 50f, center = Offset(center.x, center.y))

            drawRoundRect(color = Color.White, size = Size(40f,170f), topLeft = Offset(playerX, playerY))

            drawRoundRect(color = Color.White, size = Size(40f,170f), topLeft = Offset(botX, botY))

            drawImage(image = play, topLeft = Offset(300f, 300f))

        }
    }
}






































