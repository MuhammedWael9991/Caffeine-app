package com.caffeine.presentation.screen.coffee_details_screen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.screen.base.BaseViewModel

class CoffeeDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<CoffeeDetailsUiState>(CoffeeDetailsUiState()) , CoffeeDetailsInteractionListener {

    private val destination = savedStateHandle.toRoute<Destinations.CoffeeDetails>()

    init {
        val coffeeType = destination.type
        updateUiState { it.copy(type = coffeeType) }
    }
    override fun onClickButton(size: String) {
        navigate(Destinations.DeliverCoffee(size))
    }

    override fun onClickBack() {
        navigateUp()
    }

}