package com.caffeine.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.caffeine.presentation.navigation.CaffeineNavGraph

@Composable
fun CaffeineApp() {
    val navController = rememberNavController()

    Box(
        modifier = Modifier.statusBarsPadding()
    ){
        CaffeineNavGraph(navController)
    }
}