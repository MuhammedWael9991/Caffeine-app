package com.caffeine.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caffeine.R
import com.caffeine.ui.theme.urbanist

@Composable
fun TopBar(
    title: String,
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
    ){
        CaffeineCircleShape(icon = R.drawable.ic_back , onClick = onClickBack)
        Text(
            text = title,
            color = Color(0xFF1F1F1F),
            style = TextStyle(
                fontFamily = urbanist,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.align(Alignment.CenterVertically).padding(start = 12.dp)
        )
    }
}

@Preview
@Composable
private fun Preview(){
    TopBar(title = "Macchiato" , onClickBack = {} , modifier = Modifier.background(Color.White))
}