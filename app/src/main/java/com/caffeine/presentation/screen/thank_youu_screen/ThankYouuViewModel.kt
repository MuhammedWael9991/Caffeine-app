package com.caffeine.presentation.screen.thank_youu_screen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.screen.base.BaseViewModel

class ThankYouuViewModel(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<ThankYouuUiState>(ThankYouuUiState()) , ThankYouuInteractionListener {

    private val destination = savedStateHandle.toRoute<Destinations.ThankYouu>()

    init {
        val snak = destination.snak
        updateUiState {
            it.copy(snak = snak)
        }
    }

    override fun onClickButton() {
        navigate(Destinations.Home)
    }
}