package com.caffeine.presentation.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caffeine.R
import com.caffeine.ui.theme.sniglet

@Composable
fun WelcomeText(
    modifier: Modifier = Modifier
){

    val transition = rememberInfiniteTransition(label = "stars")


    val alpha1 by transition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, delayMillis = 0),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha1"
    )
    val alpha2 by transition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1700, delayMillis = 500),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha2"
    )
    val alpha3 by transition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1300, delayMillis = 300),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha3"
    )

    Box(
        modifier = modifier
            .height(202.dp)
            .width(203.dp)
            .background(Color.White)
    ){
        Text(
            text = "Hocus\n" +
                    "Pocus\n" +
                    "I Need Coffee\n" +
                    "to Focus"
            ,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontFamily = sniglet,
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
            ),
            modifier = Modifier.align(Alignment.Center)
        )
        Image(
            painter = painterResource(R.drawable.ic_star),
            contentDescription = "star",
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.BottomEnd).graphicsLayer { alpha = alpha1 }
        )
        Image(
            painter = painterResource(R.drawable.ic_star),
            contentDescription = "star",
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.TopEnd)
                .offset(y = 20.dp).graphicsLayer { alpha = alpha2 }
        )
        Image(
            painter = painterResource(R.drawable.ic_star),
            contentDescription = "star",
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.CenterStart)
                .offset(y = (-20).dp , x = 20.dp).graphicsLayer { alpha = alpha3 }
        )
    }
}

@Composable
@Preview
private fun Preview(){
    WelcomeText()
}

