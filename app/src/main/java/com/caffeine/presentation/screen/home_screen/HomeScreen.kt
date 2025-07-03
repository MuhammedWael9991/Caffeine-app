package com.caffeine.presentation.screen.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.caffeine.R
import com.caffeine.presentation.components.CaffeineButton
import com.caffeine.presentation.components.CaffeineCircleShape
import com.caffeine.presentation.components.CoffeeGhost
import com.caffeine.presentation.components.WelcomeText
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = koinInject()
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
        ){
            CaffeineCircleShape(icon = R.drawable.ic_ghost)
            CaffeineCircleShape(icon = R.drawable.ic_plus)
        }
        WelcomeText(modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 26.dp))
        CoffeeGhost(modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 33.dp))
        CaffeineButton(
            title = "bring my coffee",
            icon = R.drawable.ic_coffee_mag,
            onClick = { viewModel.onClickButton() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 50.dp , top = 60.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewUi(){
    HomeScreen()
}

@Preview
@Composable
private fun Preview(){
    HomeScreen()
}
