package pong.clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
//
    val screen = Pair((screenWidthDp * density) / 160, (screenHeightDp * density) / 160)

    val textMeasurer = rememberTextMeasurer()
    var playerX by remember { mutableFloatStateOf(0f) }
    var playerY by remember { mutableFloatStateOf(120f) }
    var isDragging by remember { mutableStateOf(false) }
    var playerScore by remember { mutableIntStateOf(0) }


    var botX by remember { mutableFloatStateOf(0f) }
    var botY by remember { mutableFloatStateOf(0f) }
    var botScore by remember { mutableIntStateOf(0) }

    var ballX by remember { mutableFloatStateOf(screen.first.toFloat() / 2) }
    var ballY by remember { mutableFloatStateOf(screen.second.toFloat() / 2) }
    var speedX by remember { mutableFloatStateOf(5f) }
    var speedY by remember { mutableFloatStateOf(5f) }
    val ballRadius = 50f

    Box(modifier = Modifier
        .fillMaxSize()
        .border(3.dp, Color.White, shape = RoundedCornerShape(40.dp))
    )
    {
        Canvas(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .pointerInput(Unit){
                detectDragGestures(
                    onDragStart = {offset -> isDragging = true},
                    onDragEnd = {isDragging = false},
                    onDrag = {change, dragAmount -> if (isDragging) playerY += dragAmount.y else playerY = (size.height/2 - 170/2).toFloat() }
                )
            }
        )
        {
            val canvasWidth = size.width
            val canvasHeight = size.height

            playerX = canvasWidth - 80


            botX = 40f
            botY = canvasHeight/2 - 170/2
            drawText(textMeasurer, "Drag the right paddle to move up and down", topLeft = Offset(canvasWidth/2.7f, canvasHeight-100))

            ballX += speedX
            ballY += speedY

            if (ballX - ballRadius*2 <= 0) {
                speedX *= -1f
                //playerScore += 1
            }

            if (ballX + ballRadius >= playerX ){
                speedX *= -1f
               // botScore += 1
            }

            if (ballY + ballRadius >= canvasHeight || ballY - ballRadius <= 0){
                speedY *= -1f
            }

            if (ballX + ballRadius >= playerX) botScore += 1
            if (ballX - ballRadius <= 0) playerScore += 1


            drawCircle(Color.DarkGray, radius = 320f, center = center)

            drawCircle(Color.White, ballRadius, center = Offset(ballX, ballY))

            drawRoundRect(color = Color.White, size = Size(40f,170f), topLeft = Offset(playerX, playerY), cornerRadius = CornerRadius(15f, 15f))

            botY = ballY - ballRadius
            drawRoundRect(color = Color.White, size = Size(40f,170f), topLeft = Offset(botX, botY), cornerRadius = CornerRadius(15f, 15f))

            drawText(textMeasurer, botScore.toString(), topLeft = Offset(canvasWidth/4f, 100f),
                style = TextStyle(
                    Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold))

            drawText(textMeasurer, playerScore.toString(), topLeft = Offset(canvasWidth/2f + canvasWidth/4f, 100f),
                style = TextStyle(
                    Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold))

        }

    }
}


























