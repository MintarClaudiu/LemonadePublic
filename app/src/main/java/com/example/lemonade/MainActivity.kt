package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                    ImageWithText()

            }
        }
    }
}
@Preview
@Composable
fun ImageWithText(modifier: Modifier=Modifier){
    var stateNumber by remember { mutableStateOf(1) }
    var interations =(2..4).random()
    Column(modifier= modifier
        .fillMaxSize()
        .clickable {
            if (stateNumber == 4) {
                stateNumber = 1
            } else if (stateNumber == 2) {
                if (interations > 0)
                    interations--
                else
                    stateNumber++

            } else
                stateNumber++

        }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Surface(color = Color.Cyan, shape = CircleShape) {
            Image(
                painter = painterResource(
                    id = when (stateNumber) {
                        1 -> R.drawable.lemon_tree
                        2 -> R.drawable.lemon_squeeze
                        3 -> R.drawable.lemon_drink
                        4 -> R.drawable.lemon_restart
                        else -> R.drawable.lemon_tree

                    }
                ), contentDescription = null, modifier = modifier.padding(32.dp)
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = when(stateNumber){
            1->"Tap the lemon tree to get the lemon"
            2->"Keep tapping the lemon to squeeze it"
            3->"Tap the lemonade to drink it"
            4->"Tap the empty glass to start again"
            else->" "
        }, fontSize = 30.sp, textAlign = TextAlign.Center)





    }


}



@Composable
fun GreetingPreview() {
    LemonadeTheme {
    }
}