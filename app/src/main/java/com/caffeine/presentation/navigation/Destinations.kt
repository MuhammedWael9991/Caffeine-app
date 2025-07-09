package com.caffeine.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.caffeine.presentation.screen.home_screen.HomeScreen
import kotlinx.serialization.Serializable
import androidx.navigation.compose.composable
import com.caffeine.presentation.screen.coffee_details_screen.CoffeeDetailsScreen
import com.caffeine.presentation.screen.deliver_coffee_screen.DeliverCoffeeScreen
import com.caffeine.presentation.screen.ready_coffee_screen.ReadyCoffeeScreen
import com.caffeine.presentation.screen.select_coffee_screen.SelectCoffeeScreen
import com.caffeine.presentation.screen.snak_screen.SnakScreen
import com.caffeine.presentation.screen.thank_youu_screen.ThankYouuScreen

sealed interface Destinations : Graph {

    @Serializable
    data object CaffeineGraph : Graph

    @Serializable
    data object Home : Destination

    @Serializable
    data object SelectCoffee : Destination

    @Serializable
    data class CoffeeDetails(val type: String) : Destination

    @Serializable
    data class DeliverCoffee(val size: String) : Destination

    @Serializable
    data object ReadyCoffee : Destination

    @Serializable
    data object Snak : Destination

    @Serializable
    data class ThankYouu(val snak: String) : Destination
}

fun NavGraphBuilder.buildCaffeineNavGraph() {
    navigation<Destinations.CaffeineGraph>(startDestination = Destinations.Home) {
        composable<Destinations.Home> { HomeScreen() }
        composable<Destinations.SelectCoffee> { SelectCoffeeScreen() }
        composable<Destinations.CoffeeDetails> { CoffeeDetailsScreen() }
        composable<Destinations.DeliverCoffee> { DeliverCoffeeScreen() }
        composable<Destinations.ReadyCoffee> { ReadyCoffeeScreen() }
        composable<Destinations.Snak> { SnakScreen() }
        composable<Destinations.ThankYouu> { ThankYouuScreen() }
    }
}