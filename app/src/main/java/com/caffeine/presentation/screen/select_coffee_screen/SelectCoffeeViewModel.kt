package com.caffeine.presentation.screen.select_coffee_screen

import androidx.lifecycle.SavedStateHandle
import com.caffeine.presentation.screen.base.BaseViewModel

class SelectCoffeeViewModel(
) : BaseViewModel<SelectCoffeeUiState>(SelectCoffeeUiState()) , SelectCoffeeInteractionListener {

    override fun onClickButton() {
        //navigate(Destinations.DeliverCoffee)
    }

}