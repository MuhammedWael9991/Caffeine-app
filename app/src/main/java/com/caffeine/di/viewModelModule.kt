package com.caffeine.di

import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.navigation.Navigator
import com.caffeine.presentation.navigation.NavigatorImpl
import com.caffeine.presentation.screen.home_screen.HomeScreenViewModel
import com.caffeine.presentation.screen.select_coffee_screen.SelectCoffeeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeScreenViewModel() }
    viewModel { SelectCoffeeViewModel() }

    single<Navigator> { NavigatorImpl(startGraph = Destinations.CaffeineGraph) }
}
