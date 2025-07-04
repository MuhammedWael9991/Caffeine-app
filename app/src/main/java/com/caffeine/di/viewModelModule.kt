package com.caffeine.di

import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.navigation.Navigator
import com.caffeine.presentation.navigation.NavigatorImpl
import com.caffeine.presentation.screen.coffee_details_screen.CoffeeDetailsViewModel
import com.caffeine.presentation.screen.deliver_coffee_screen.DeliverCoffeeViewModel
import com.caffeine.presentation.screen.home_screen.HomeScreenViewModel
import com.caffeine.presentation.screen.ready_coffee_screen.ReadyCoffeeViewModel
import com.caffeine.presentation.screen.select_coffee_screen.SelectCoffeeViewModel
import com.caffeine.presentation.screen.snak_screen.SnakViewModel
import com.caffeine.presentation.screen.thank_youu_screen.ThankYouuViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeScreenViewModel() }
    viewModel { SelectCoffeeViewModel() }
    viewModel { CoffeeDetailsViewModel() }
    viewModel { DeliverCoffeeViewModel() }
    viewModel { ThankYouuViewModel() }
    viewModel { SnakViewModel() }
    viewModel { ReadyCoffeeViewModel() }
    single<Navigator> { NavigatorImpl(startGraph = Destinations.CaffeineGraph) }
}
