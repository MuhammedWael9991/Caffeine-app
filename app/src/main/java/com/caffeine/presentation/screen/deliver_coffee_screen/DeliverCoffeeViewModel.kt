package com.caffeine.presentation.screen.deliver_coffee_screen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.screen.base.BaseViewModel

class DeliverCoffeeViewModel(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<DeliverCoffeeUiState>(DeliverCoffeeUiState()) , DeliverCoffeeInteractionListener {

    private val destination = savedStateHandle.toRoute<Destinations.DeliverCoffee>()

    init {
        val coffeeSize = destination.size
        updateUiState {
            it.copy(size = coffeeSize)
        }
    }

    override fun onFinish() {
        navigate(Destinations.ReadyCoffee)
    }

}