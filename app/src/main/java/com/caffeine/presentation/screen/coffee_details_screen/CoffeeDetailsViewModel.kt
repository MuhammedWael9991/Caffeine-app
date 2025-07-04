package com.caffeine.presentation.screen.coffee_details_screen

import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.screen.base.BaseViewModel

class CoffeeDetailsViewModel(

) : BaseViewModel<CoffeeDetailsUiState>(CoffeeDetailsUiState()) , CoffeeDetailsInteractionListener {
    override fun onClickButton() {
        navigate(Destinations.DeliverCoffee)
    }
}