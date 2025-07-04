package com.caffeine.presentation.screen.snak_screen

import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.screen.base.BaseViewModel

class SnakViewModel(

) : BaseViewModel<SnakUiState>(SnakUiState()), SnakInteractionListener {
    override fun onClickCard() {
        navigate(Destinations.ThankYouu)
    }

}