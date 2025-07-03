package com.caffeine.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caffeine.ui.theme.white
import kotlinx.coroutines.delay

@Composable
fun SizeSwitch(
    selectedSize: CupSize,
    onSizeSelected: (CupSize) -> Unit,
    modifier: Modifier = Modifier
) {
    var internalText by remember { mutableStateOf(selectedSize.label) }
    var alpha by remember { mutableStateOf(1f) }

    val targetOffsetX = when (internalText) {
        "S" -> 10.dp
        "M" -> 55.dp
        "L" -> 105.dp
        else -> 0.dp
    }

    val animatedOffsetX by animateDpAsState(
        targetValue = targetOffsetX,
        animationSpec = tween(durationMillis = 200),
        label = "SizeSwitchOffset"
    )

    val animatedAlpha by animateFloatAsState(
        targetValue = alpha,
        animationSpec = tween(durationMillis = 200),
        label = "AlphaAnimation"
    )

    LaunchedEffect(selectedSize) {
        alpha = 0f
        delay(200)
        internalText = selectedSize.label
        alpha = 1f
    }

    Box(
        modifier = modifier
            .width(152.dp)
            .height(56.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(white)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf("S", "M", "L").forEach { label ->
                Text(
                    text = label,
                    color = Color(0xFF1F1F1F).copy(alpha = 0.6f),
                    style = TextStyle(fontSize = 20.sp),
                    modifier = Modifier.clickable {
                        onSizeSelected(CupSize.fromLabel(label))
                    }
                )
            }
        }

        SelectShape(
            isSize = true,
            text = internalText,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = animatedOffsetX)
                .graphicsLayer { this.alpha = animatedAlpha }
        )
    }
}

enum class CupSize(val label: String) {
    Small("S"),
    Medium("M"),
    Large("L");

    companion object {
        fun fromLabel(label: String): CupSize =
            when (label) {
                "S" -> Small
                "M" -> Medium
                "L" -> Large
                else -> Medium
            }
    }
}


@Preview
@Composable
private fun Preview(){
    SizeSwitch(
        selectedSize = CupSize.Medium,
        onSizeSelected = {},
        modifier = Modifier
            .padding(vertical = 16.dp)
    )
}