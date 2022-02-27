package me.ameerhamza.cryptopedia.presentation.coin_list.ui_state

import me.ameerhamza.cryptopedia.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
