package com.caffeine.presentation.screen.select_coffee_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.screen.base.BaseViewModel

class SelectCoffeeViewModel:
    BaseViewModel<SelectCoffeeUiState>(SelectCoffeeUiState()) , SelectCoffeeInteractionListener {

    private val _selectedIndex = mutableIntStateOf(0)
    val selectedIndex: State<Int> = _selectedIndex

    fun onCoffeeSelected(index: Int) {
        _selectedIndex.intValue = index
    }

    override fun onClickButton(selectedCoffee: String) {
        navigate(Destinations.CoffeeDetails(selectedCoffee))
    }

}