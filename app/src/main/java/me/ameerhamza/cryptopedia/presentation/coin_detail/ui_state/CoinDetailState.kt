package me.ameerhamza.cryptopedia.presentation.coin_detail.ui_state

import me.ameerhamza.cryptopedia.domain.model.Coin
import me.ameerhamza.cryptopedia.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
