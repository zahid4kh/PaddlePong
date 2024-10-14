package pong.clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
@Preview(showSystemUi = true, showBackground = true)
fun Lol(modifier: Modifier = Modifier) {
    
}