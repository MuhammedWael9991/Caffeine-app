package com.caffeine.di

import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.navigation.Navigator
import com.caffeine.presentation.navigation.NavigatorImpl
import org.koin.dsl.module


val viewModelModule = module {
    single<Navigator> { NavigatorImpl(startGraph = Destinations.CaffeineGraph) }
}