package com.caffeine.presentation

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.navigation.compose.rememberNavController
import com.caffeine.presentation.navigation.CaffeineNavGraph

@Composable
fun CaffeineApp() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val activity = context as? ComponentActivity
    val view = LocalView.current

    Box(
        modifier = Modifier.statusBarsPadding()
    ){
        CaffeineNavGraph(navController)
    }
}