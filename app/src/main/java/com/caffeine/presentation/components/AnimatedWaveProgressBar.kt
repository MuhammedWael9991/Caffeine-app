package com.caffeine.presentation.components


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke


@Composable
fun AnimatedWaveProgressBar(
    modifier: Modifier = Modifier,
    waveHeight: Float = 80f,
    waveLength: Float = 200f,
    waveStroke: Float = 4f,
    waveColor: Color = Color.Black
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val animatedWidth = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        while (true) {
            animatedWidth.animateTo(
                targetValue = screenWidth.value,
                animationSpec = tween(2000, easing = LinearEasing)
            )
            animatedWidth.animateTo(
                targetValue = 60f,
                animationSpec = tween(2000, easing = LinearEasing)
            )
        }
    }

    Canvas(
        modifier = modifier
            .height(waveHeight.dp * 2)
            .width(animatedWidth.value.dp)
    ) {
        val path = androidx.compose.ui.graphics.Path()
        val centerY = size.height / 2
        var startX = 0f

        while (startX < size.width) {
            path.moveTo(startX, centerY)

            val controlPoint1X = startX + waveLength / 4
            val controlPoint1Y = centerY - waveHeight

            val controlPoint2X = startX + 3 * waveLength / 5
            val controlPoint2Y = centerY + waveHeight

            val endX = startX + waveLength
            val endY = centerY

            path.cubicTo(
                controlPoint1X, controlPoint1Y,
                controlPoint2X, controlPoint2Y,
                endX, endY
            )

            startX += waveLength
        }

        drawPath(
            path = path,
            color = waveColor,
            style = Stroke(width = waveStroke, cap = StrokeCap.Round)
        )
    }
}




@Preview
@Composable
private fun Preview(){
    AnimatedWaveProgressBar()
}