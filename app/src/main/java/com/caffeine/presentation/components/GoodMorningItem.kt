package com.caffeine.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.caffeine.ui.theme.urbanist

@Composable
fun GoodMorningItem(
    name: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.background(Color.White)
    ) {

        Text(
            text = "Good Morning",
            color = Color(0xFFB3B3B3),
            style = TextStyle(
                fontFamily = urbanist,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            text = "$name ☀",
            color = Color(0xFF3B3B3B),
            style = TextStyle(
                fontFamily = urbanist,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            text = "What would you like to drink today?",
            color = Color(0xFF1F1F1F).copy(alpha = 0.8f),
            style = TextStyle(
                fontFamily = urbanist,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview
@Composable
private fun Preview(){
    GoodMorningItem("Hamsa")
}
