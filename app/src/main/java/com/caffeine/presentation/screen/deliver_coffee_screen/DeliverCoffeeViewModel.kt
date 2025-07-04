package com.caffeine.presentation.screen.deliver_coffee_screen

import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.screen.base.BaseViewModel

class DeliverCoffeeViewModel(

) : BaseViewModel<DeliverCoffeeUiState>(DeliverCoffeeUiState()) , DeliverCoffeeInteractionListener {
    override fun onFinish() {
        navigate(Destinations.ReadyCoffee)
    }

}