package com.caffeine.presentation.screen.deliver_coffee_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.caffeine.presentation.components.AnimatedWaveProgressBar
import com.caffeine.ui.theme.brawn
import com.caffeine.ui.theme.sniglet
import com.caffeine.ui.theme.urbanist
import kotlinx.coroutines.delay
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DeliverCoffeeScreen(
    modifier: Modifier = Modifier,
    viewModel: DeliverCoffeeViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) {
    delay(3000)
    viewModel.onFinish()
}

    val cupImageSize = 250.dp
    val logoImageSize = 90.dp

    Box(
        modifier = modifier.fillMaxSize().padding(top = 120.dp)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(341.dp)
                .padding(top = 60.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_starbuks),
                contentDescription = "Cup",
                modifier = Modifier.align(Alignment.Center).size(cupImageSize)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_starbuks_logo),
                contentDescription = "Logo",
                modifier = Modifier.align(Alignment.Center).size(logoImageSize)
            )

            Text(
                text = "150 ML",
                color = Color(0xFF000000).copy(alpha = 0.6f),
                style = TextStyle(
                    fontFamily = urbanist,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                ),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 64.dp, start = 16.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 120.dp)
        ) {
            AnimatedWaveProgressBar()
        }
        Box(
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 50.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Almost Done",
                    style = TextStyle(
                        fontFamily = urbanist,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = "Your coffee will be finish in",
                    color = Color(0xFF1F1F1F).copy(alpha = 0.6f),
                    style = TextStyle(
                        fontFamily = urbanist,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "FF",
                        color = brawn,
                        style = TextStyle(
                            fontFamily = sniglet,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_colon),
                        contentDescription = "Colon",
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "CO",
                        color = brawn,
                        style = TextStyle(
                            fontFamily = sniglet,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_colon),
                        contentDescription = "Colon",
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "EE",
                        color = brawn,
                        style = TextStyle(
                            fontFamily = sniglet,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                    )
                }
            }
        }
    }

}

@Composable
fun DeliverCoffeeScreen2() {

    val cupImageSize = 250.dp
    val logoImageSize = 90.dp

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(341.dp)
                    .padding(top = 60.dp)
                    .background(Color(0xFFE0F7FA))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_starbuks),
                    contentDescription = "Cup",
                    modifier = Modifier.align(Alignment.Center).size(cupImageSize)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_starbuks_logo),
                    contentDescription = "Logo",
                    modifier = Modifier.align(Alignment.Center).size(logoImageSize)
                )

                Text(
                    text = "150 ML",
                    color = Color(0xFF000000).copy(alpha = 0.6f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 64.dp, start = 16.dp)
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()

            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedWaveProgressBar()

                Text(
                    text = "Almost Done",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = "Your coffee will be finish in",
                    color = Color(0xFF1F1F1F).copy(alpha = 0.6f),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "FF",
                        color = brawn,
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_colon),
                        contentDescription = "Colon",
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "CO",
                        color = brawn,
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_colon),
                        contentDescription = "Colon",
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "EE",
                        color = brawn,
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun Preview(){
    DeliverCoffeeScreen()
}