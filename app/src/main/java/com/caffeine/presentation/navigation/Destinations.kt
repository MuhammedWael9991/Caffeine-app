package com.caffeine.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.caffeine.presentation.screen.home_screen.HomeScreen
import kotlinx.serialization.Serializable
import androidx.navigation.compose.composable
import com.caffeine.presentation.screen.select_coffee_screen.SelectCoffeeScreen

sealed interface Destinations : Graph {

    @Serializable
    data object CaffeineGraph : Graph

    @Serializable
    data object Home : Destination

    @Serializable
    data object SelectCoffee : Destination

    @Serializable
    data object CoffeeDetails : Destination

    @Serializable
    data object DeliverCoffee : Destination

    @Serializable
    data object Snak : Destination

    @Serializable
    data object ThankYouu : Destination
}

fun NavGraphBuilder.buildCaffeineNavGraph() {
    navigation<Destinations.CaffeineGraph>(startDestination = Destinations.Home) {
        composable<Destinations.Home> { HomeScreen() }
        composable<Destinations.SelectCoffee> { SelectCoffeeScreen() }

    }
}