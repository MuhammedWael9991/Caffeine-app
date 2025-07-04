package com.caffeine.presentation.screen.home_screen

import androidx.lifecycle.SavedStateHandle
import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.screen.base.BaseViewModel


class HomeScreenViewModel(
) : BaseViewModel<HomeUiState>(HomeUiState()) , HomeInteractionListener {


    override fun onClickButton() {
        navigate(Destinations.SelectCoffee)
    }

}