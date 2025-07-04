package com.caffeine.presentation.screen.coffee_details_screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
import kotlinx.coroutines.delay
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CoffeeDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: CoffeeDetailsViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    val cupSize = remember { mutableStateOf(CupSize.Medium) }
    val coffeeLevel = remember { mutableStateOf("Low") }

    val beanCount = remember { mutableStateOf(0) }
    var previousLevel by remember { mutableStateOf("Low") }

    val isReversed = remember { mutableStateOf(false) }

    LaunchedEffect(coffeeLevel.value) {
        val current = when (coffeeLevel.value) {
            "Low" -> 0
            "Medium" -> 1
            "High" -> 2
            else -> 0
        }

        val previous = when (previousLevel) {
            "Low" -> 0
            "Medium" -> 1
            "High" -> 2
            else -> 0
        }



        isReversed.value = current < previous

        if (current > previous) {
            beanCount.value++
        } else if (current < previous) {
            beanCount.value++
        }

        previousLevel = coffeeLevel.value
    }

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
        label = "LogoImageSize"
    )

    Column(
        modifier = modifier.fillMaxSize().background(Color.White)
    ) {
        TopBar(
            uiState.type,
            onClickBack = { viewModel.onClickBack() },
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
            val ml by remember {
                derivedStateOf {
                    when (cupSize.value) {
                        CupSize.Small -> "150 ML"
                        CupSize.Medium -> "200 ML"
                        CupSize.Large -> "400 ML"
                    }
                }
            }
            Text(
                text = ml,
                color = Color(0xFF000000).copy(alpha = 0.6f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 64.dp, start = 16.dp)
            )


//            for (i in 0 until beanCount.value) {
//                AnimatedCoffeeBean(index = i)
//            }
        }

        SizeSwitch(
            selectedSize = cupSize.value,
            onSizeSelected = { cupSize.value = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp)
        )

        CaffeineSwitch(
            selectedLevel = coffeeLevel.value,
            onLevelChanged = { coffeeLevel.value = it },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)

        )

        CaffeineButton(
            title = "Continue",
            icon = R.drawable.ic_arrow,
            onClick = { viewModel.onClickButton() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding( top = 100.dp)
        )
    }
}
//
//@Composable
//fun AnimatedCoffeeBean(index: Int, reversed: Boolean = false) {
//    val startYOffset = if (reversed) 80.dp else -200.dp
//    val endYOffset = if (reversed) -200.dp else 80.dp
//
//    var isVisible by remember { mutableStateOf(false) }
//
//    LaunchedEffect(Unit) {
//        delay(300)
//        isVisible = true
//        delay(300)
//        isVisible = false
//    }
//
//    val yOffset by animateDpAsState(
//        targetValue = if (isVisible) endYOffset else startYOffset,
//        animationSpec = tween(600),
//        label = "beanYOffset"
//    )
//
//    val alpha by animateFloatAsState(
//        targetValue = if (isVisible) 1f else 0f,
//        animationSpec = tween(600),
//        label = "beanAlpha"
//    )
//
//    Image(
//        painter = painterResource(id = R.drawable.ic_coffee_beans),
//        contentDescription = "Bean",
//        modifier = Modifier
//            .offset(x = 50.dp, y = yOffset)
//            .graphicsLayer { this.alpha = alpha }
//    )
//}




@Preview
@Composable
private fun Preview(){
    CoffeeDetailsScreen()
}

