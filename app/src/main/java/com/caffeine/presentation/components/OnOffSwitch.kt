package com.caffeine.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caffeine.R
import com.caffeine.ui.theme.brawn
import com.caffeine.ui.theme.white2

@Composable
fun OnOffSwitch(modifier: Modifier = Modifier){

    var isEnable by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(
        targetValue = if (isEnable) brawn else white2,
        animationSpec = tween(durationMillis = 300),
        label = "backgroundColorAnimation"
    )
    val option = listOf("OFF", "ON")

    val x by animateDpAsState(
        targetValue = if (isEnable) 0.dp else 38.dp,
        animationSpec = tween(durationMillis = 450),
        label = "xAnimation"
    )

    Box(
        modifier = modifier
            .height(40.dp)
            .width(78.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(backgroundColor)
            .clickable { isEnable = !isEnable }

    ){
        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            option.forEach {
                Text(
                    text = it,
                    color = if (it == "OFF") Color(0xFF000000).copy(alpha = 0.6f) else Color.White.copy(0.6f),
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

        }
        Image(
            painter = painterResource(R.drawable.ic_mug),
            contentDescription = null,
            modifier = Modifier.offset(x = x)
        )
    }
}

@Preview
@Composable
private fun Preview(){
    OnOffSwitch()
}