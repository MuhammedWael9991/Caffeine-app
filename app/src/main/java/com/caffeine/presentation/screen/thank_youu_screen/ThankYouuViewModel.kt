package com.caffeine.presentation.screen.thank_youu_screen

import com.caffeine.presentation.navigation.Destinations
import com.caffeine.presentation.screen.base.BaseViewModel

class ThankYouuViewModel(

) : BaseViewModel<ThankYouuUiState>(ThankYouuUiState()) , ThankYouuInteractionListener {
    override fun onClickButton() {
        navigate(Destinations.Home)
    }
}