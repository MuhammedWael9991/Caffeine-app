package com.caffeine.presentation.screen.ready_coffee_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caffeine.R
import com.caffeine.presentation.components.CaffeineButton
import com.caffeine.presentation.components.CaffeineCircleShape
import com.caffeine.presentation.components.OnOffSwitch
import com.caffeine.presentation.components.SelectShape
import com.caffeine.ui.theme.urbanist
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ReadyCoffeeScreen(
    viewModel: ReadyCoffeeViewModel = koinViewModel()
){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        CaffeineCircleShape(
            modifier = Modifier.padding(start = 16.dp),
            onClick = {
                viewModel.onClickExit()
            },
            icon = R.drawable.ic_exit
        )
        Column(
            modifier = Modifier.padding(top = 16.dp).align(Alignment.CenterHorizontally)
        ) {
            SelectShape(
                isSize = false,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                icon = R.drawable.ic_true,
                circleSize = 56.dp
            )
            Text(
                text = "Your coffee is ready,\n" +
                        "Enjoy",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontFamily = urbanist,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = 24.dp)
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .height(370.dp)
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                Box{
                    Image(
                        painter = painterResource(R.drawable.ic_starbuks),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth().height(300.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.ic_starbuks_logo),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .size(64.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.cover),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(69.dp)
                            .offset(y = (-20).dp)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(27.dp)
        ){
            Column {
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ){
                    OnOffSwitch()
                    Text(
                        text = "Take Away",
                        color = Color(0xFF1F1F1F).copy(alpha = 0.7f),
                        style = TextStyle(
                            fontFamily = urbanist,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
                CaffeineButton(
                    title = "Take snack",
                    icon = R.drawable.ic_arrow,
                    onClick = { viewModel.onClickButton() },
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    ReadyCoffeeScreen()
}