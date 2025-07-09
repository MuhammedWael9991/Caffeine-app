package com.caffeine.presentation.screen.select_coffee_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.caffeine.R
import com.caffeine.presentation.components.CaffeineButton
import com.caffeine.presentation.components.CaffeineCircleShape
import com.caffeine.presentation.components.GoodMorningItem
import org.koin.compose.koinInject
import kotlin.math.abs

@Composable
fun SelectCoffeeScreen(
    modifier: Modifier = Modifier,
    viewModel: SelectCoffeeViewModel = koinInject()
){

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CaffeineCircleShape(icon = R.drawable.ic_ghost)
            CaffeineCircleShape(icon = R.drawable.ic_plus)
        }
        GoodMorningItem("Hamsa" , modifier = Modifier.padding(top = 16.dp , start = 16.dp))

        ZoomPager(
            items = itemsList,
            modifier = Modifier
                .padding(top = 106.dp),
            onItemSelected = { index ->
                viewModel.onCoffeeSelected(index)
            }
        )

        val selectedIndex = viewModel.selectedIndex.value
        val selectedCoffeeName = coffeeNamesList[selectedIndex]

        CaffeineButton(
            title = "Continue",
            icon = R.drawable.ic_arrow,
            onClick = { viewModel.onClickButton(selectedCoffeeName) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 50.dp , top = 111.dp)
        )
    }
}

val itemsList = listOf(
    R.drawable.black,
    R.drawable.macchiato,
    R.drawable.latte,
    R.drawable.espresso
)

val coffeeNamesList = listOf(
    "Black",
    "Macchiato",
    "Latte",
    "Espresso"
)


@Composable
private fun ZoomPager(
    items: List<Int>,
    modifier: Modifier = Modifier,
    onItemSelected: (Int) -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { items.size }
    )


    LaunchedEffect(pagerState.currentPage) {
        onItemSelected(pagerState.currentPage)
    }

    HorizontalPager(
        state = pagerState,
        pageSpacing = 16.dp,
        contentPadding = PaddingValues(horizontal = 100.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
    ) { page ->

        val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
        val scale = 1.5f - abs(pageOffset) * 0.6f

        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .padding(8.dp)
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = items[page]),
                contentDescription = null,
                modifier = Modifier
            )
        }
    }
}



@Preview(showSystemUi = true)
@Composable
private fun Preview(){
    SelectCoffeeScreen()
}