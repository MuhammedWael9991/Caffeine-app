package com.caffeine.presentation.screen.ready_coffee_screen

import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.screen.base.BaseViewModel

class ReadyCoffeeViewModel(

) : BaseViewModel<ReadyCoffeeUiState>(ReadyCoffeeUiState()) , ReadyCoffeeInteractionListener {
    override fun onClickButton() {
        navigate(Destinations.Snak)
    }

}