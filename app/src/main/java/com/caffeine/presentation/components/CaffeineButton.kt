package com.caffeine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caffeine.R
import com.caffeine.ui.theme.black
import com.caffeine.ui.theme.urbanist
import com.caffeine.ui.theme.white

@Composable
fun CaffeineButton(
    title: String,
    icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier
            .height(56.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(black)
            .clickable { onClick() }
    ){
        Row(
            modifier = Modifier.align(Alignment.Center)
        ){
            Text(
                text = title,
                color = white,
                style = TextStyle(
                    fontFamily = urbanist,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 32.dp).align(Alignment.CenterVertically)
            )
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.padding(start = 8.dp , end = 32.dp)
            )
        }
    }
}

@Preview
@Composable
private fun Preview(){
    Column {
        CaffeineButton(
            title = "continue",
            icon = R.drawable.ic_arrow,
            {}
        )
        CaffeineButton(
            title = "brign my coffee",
            icon = R.drawable.ic_coffee_mag,
            {},
            modifier = Modifier.padding(vertical = 16.dp)
        )
        CaffeineButton(
            title = "Take snack",
            icon = R.drawable.ic_arrow,
            {},
            modifier = Modifier.padding(vertical = 16.dp)
        )
        CaffeineButton(
            title = "Thank youuu",
            icon = R.drawable.ic_arrow,
            {}
        )
    }
}