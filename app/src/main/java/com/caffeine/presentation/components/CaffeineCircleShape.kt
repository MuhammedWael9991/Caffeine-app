package com.caffeine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.caffeine.R
import com.caffeine.ui.theme.white

@Composable
fun CaffeineCircleShape(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    icon: Int = 0
){
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(white)
            .clickable { onClick() }
    ){
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
@Preview
private fun Preview(){
    Column {
        CaffeineCircleShape(icon = R.drawable.ic_ghost)
        CaffeineCircleShape(icon = R.drawable.ic_plus)
    }
}