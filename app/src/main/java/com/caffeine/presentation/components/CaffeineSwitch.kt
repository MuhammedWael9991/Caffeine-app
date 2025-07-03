package com.caffeine.presentation.components


import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caffeine.ui.theme.white
import kotlinx.coroutines.delay


@Composable
fun CaffeineSwitch(
    modifier: Modifier = Modifier,
){
    var selected by remember { mutableStateOf("Low") }
    var pendingSelected by remember { mutableStateOf<String?>(null) }
    var visible by remember { mutableStateOf(true) }

    val x = when (selected) {
        "Low" -> 10.dp
        "Medium" -> 55.dp
        "High" -> 105.dp
        else -> 0.dp
    }

    val options = listOf("Low", "Medium", "High")

    Column(
        modifier = modifier
        .width(152.dp)
    ){
        Box(
            modifier = modifier
                .width(152.dp)
                .height(56.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(white)
        ) {
            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                options.forEach {
                    Box(
                        Modifier.fillMaxHeight().width(50.dp)
                            .clickable {
                                if (it != selected){
                                    visible = false
                                    pendingSelected = it
                                }
                            }
                    )
                }
            }

            androidx.compose.animation.AnimatedVisibility(
                visible = visible,
                enter = fadeIn(tween(200)),
                exit = fadeOut(tween(200)),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(x = x)
            ) {
                SelectShape(isSize = false)
            }
            LaunchedEffect(visible) {
                if (!visible && pendingSelected != null) {
                    delay(200)
                    selected = pendingSelected!!
                    pendingSelected = null
                    visible = true
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            options.forEach {
                Text(
                    text = it,
                    style = TextStyle(
                        fontSize = 10.sp,
                        color = Color(0xFF1F1F1F).copy(alpha = 0.6f),
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    CaffeineSwitch()
}