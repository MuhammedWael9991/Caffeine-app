package com.caffeine.presentation.components


import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.caffeine.R
import androidx.compose.animation.core.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp


@Composable
fun CoffeeGhost(
    modifier: Modifier = Modifier
){

    val infiniteTransition = rememberInfiniteTransition(label = "floating")

    val offsetY by infiniteTransition.animateValue(
        initialValue = 0.dp,
        targetValue = (-10).dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "floatingOffset"
    )

    val normalized = (offsetY.value / -12f).coerceIn(0f, 1f)

    val alpha = 0.6f + (1f - normalized) * 0.4f

    Box(
        modifier = modifier
            .height(300.dp)
            .width(244.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.coffe_ghost),
                contentDescription = "Coffee Ghost",
                modifier = Modifier.offset(y = offsetY)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ){
                Image(
                    painter = painterResource(R.drawable.coffe_ghost_shadow),
                    contentDescription = "Coffee Ghost Shadow",
                    modifier = Modifier
                        .width(180.dp)
                        .align(Alignment.Center)
                        .graphicsLayer {
                            this.alpha = alpha
                        }
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    CoffeeGhost()
}