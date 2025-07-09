package com.caffeine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caffeine.R
import com.caffeine.ui.theme.brawn
import com.caffeine.ui.theme.urbanist
import com.caffeine.ui.theme.white

@Composable
fun SelectShape(
    isSize: Boolean,
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.ic_coffee,
    text: String = "",
    circleSize: Dp = 40.dp
){
    Box(
        modifier = modifier
            .size(circleSize)
            .shadow(
                elevation = 0.dp,
                shape = CircleShape,
                ambientColor = Color.Transparent,
                spotColor = Color.Transparent
            )
            .drawBehind {
                val shadowColor = Color(0x80B94B23)
                val paint = Paint().asFrameworkPaint().apply {
                    isAntiAlias = true
                    color = android.graphics.Color.TRANSPARENT
                    setShadowLayer(16f, 0f, 6f, shadowColor.toArgb())
                }

                drawContext.canvas.nativeCanvas.apply {
                    save()
                    drawCircle(
                        size.width / 2f,
                        size.height / 2f,
                        size.minDimension / 2f,
                        paint
                    )
                    restore()
                }
            }
            .clip(CircleShape)
            .background(brawn)
    ){
        if (isSize){
            Text(
                text = text,
                color = white,
                style = TextStyle(
                    fontFamily = urbanist,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                modifier = Modifier.align(Alignment.Center)
            )
        }else
        {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
private fun Preview(){
    Column {
        SelectShape(isSize = true , text = "S")
        SelectShape(isSize = false)
    }
}