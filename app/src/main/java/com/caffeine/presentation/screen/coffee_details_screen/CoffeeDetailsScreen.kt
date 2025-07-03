package com.caffeine.presentation.screen.coffee_details_screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caffeine.R
import com.caffeine.presentation.components.CaffeineButton
import com.caffeine.presentation.components.CaffeineSwitch
import com.caffeine.presentation.components.CupSize
import com.caffeine.presentation.components.SizeSwitch
import com.caffeine.presentation.components.TopBar


@Composable
fun CoffeeDetailsScreen(
    modifier: Modifier = Modifier,
){

    val cupSize = remember { mutableStateOf(CupSize.Medium) }


    val cupImageSize by animateDpAsState(
        targetValue = when (cupSize.value) {
            CupSize.Small -> 200.dp
            CupSize.Medium -> 250.dp
            CupSize.Large -> 320.dp
        },
        label = "CupImageSize"
    )
    val logoImageSize by animateDpAsState(
        targetValue = when (cupSize.value) {
            CupSize.Small -> 50.dp
            CupSize.Medium -> 60.dp
            CupSize.Large -> 90.dp
        },
        label = "CupImageSize"
    )

    Column(
        modifier = modifier.fillMaxSize().background(Color.White)
    ) {
        TopBar(
            "Macchaito",
            onClickBack = {},
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .align(Alignment.CenterHorizontally)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(341.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 60.dp)
                .background(Color.Cyan)
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_starbuks),
                contentDescription = "StarBuks",
                modifier = Modifier.align(Alignment.Center).size(cupImageSize)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_starbuks_logo),
                contentDescription = "StarBuks",
                modifier = Modifier.align(Alignment.Center).size(logoImageSize)
            )
            Text(
                text = "150 ML",
                color = Color(0xFF000000).copy(alpha = 0.6f),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 64.dp , start = 16.dp)
            )
        }
        SizeSwitch(
            selectedSize = cupSize.value,
            onSizeSelected = { selected -> cupSize.value = selected },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp)
        )
        CaffeineSwitch(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        CaffeineButton(
            title = "Continue",
            icon = R.drawable.ic_arrow,
            onClick = {  },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 50.dp , top = 60.dp)
        )
    }
}


@Preview
@Composable
private fun Preview(){
    CoffeeDetailsScreen()
}

