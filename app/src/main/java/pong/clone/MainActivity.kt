package pong.clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current
    val configuration = context.resources.configuration

    val density = getScreenDensityDpi(context)

    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp

    val screen = Pair((screenWidthDp * density) / 160, (screenHeightDp * density) / 160)

    val textMeasurer = rememberTextMeasurer()
    var playerX by remember { mutableFloatStateOf(0f) }
    var playerY by remember { mutableFloatStateOf(0f) }

    var botX by remember { mutableFloatStateOf(0f) }
    var botY by remember { mutableFloatStateOf(0f) }

    var ballX by remember { mutableFloatStateOf((((screen.first)/2).toFloat())) }
    var ballY by remember { mutableFloatStateOf((((screen.second)/2).toFloat())) }

    var isUpdate by remember { mutableStateOf(false) }
    if (isUpdate){
        ballX += 1f
        ballY += 1f
    }

    Box(modifier = Modifier
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

            drawCircle(Color.White, 50f, center = Offset(ballX, ballY))
//            ballX += 1f
//            ballY += 1f

            drawRoundRect(color = Color.White, size = Size(40f,170f), topLeft = Offset(playerX, playerY))

            drawRoundRect(color = Color.White, size = Size(40f,170f), topLeft = Offset(botX, botY))
        }
        val iconButton = if (isUpdate) Icons.Default.PlayArrow else Icons.Default.Refresh
        IconButton(onClick = {isUpdate = !isUpdate}, modifier = Modifier.padding(start = (screenWidthDp/2).dp).size(50.dp,50.dp)){
            Icon(iconButton, contentDescription = "Play Button", tint = Color.White, modifier = Modifier.size(50.dp,50.dp))
        }
    }
}





























