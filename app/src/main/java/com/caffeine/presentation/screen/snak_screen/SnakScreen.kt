package com.caffeine.presentation.screen.snak_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.caffeine.R
import com.caffeine.presentation.components.CaffeineCircleShape
import com.caffeine.ui.theme.urbanist
import org.koin.compose.viewmodel.koinViewModel
import kotlin.math.abs

@Composable
fun SnakScreen(
    viewModel: SnakViewModel = koinViewModel(),
    modifier: Modifier = Modifier
){
    val snackList = listOf(
        SnackItem("Oreo", R.drawable.oreo),
        SnackItem("Cookies", R.drawable.cookies),
        SnackItem("Chocolate", R.drawable.chocolate),
        SnackItem("Croissant", R.drawable.croissant),
        SnackItem("Lasagna", R.drawable.lasagna),
        SnackItem("Cupcake", R.drawable.cupcake)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CaffeineCircleShape(
            modifier = Modifier.padding(start = 16.dp),
            onClick = {},
            icon = R.drawable.ic_exit
        )
        Text(
            text = "Take your snack",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontFamily = urbanist,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(top = 24.dp , start = 16.dp)
        )
        Box(
            modifier = Modifier.fillMaxSize().padding(top = 16.dp)
        ){
            ZoomPager(
                items = snackList,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .offset(x = (-50).dp),
                onClick = {
                    viewModel.onClickCard(it.name)
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ZoomPager(
    items: List<SnackItem>,
    modifier: Modifier = Modifier,
    onClick: (SnackItem) -> Unit,
) {

    val pagerState = rememberPagerState(
        pageCount = { items.size },
        initialPage = 1
    )


    VerticalPager(
        state = pagerState,
        pageSpacing = 16.dp,
        contentPadding = PaddingValues(vertical = 250.dp),
        modifier = modifier
            .fillMaxSize()
    ) { page ->

        val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

        val scale = 1.7f - abs(pageOffset) * 0.15f
        val horizontalOffset = (-80f * abs(pageOffset)).dp

        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationX = horizontalOffset.toPx()
                }
                .padding(8.dp)
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = items[page].imageResId),
                contentDescription = null,
                modifier = Modifier.clickable {
                    onClick(items[page])
                }
            )

        }
    }
}

data class SnackItem(
    val name: String,
    val imageResId: Int
)

@Preview
@Composable
private fun Preview(){
    SnakScreen()
}