package me.ameerhamza.cryptopedia.presentation.coin_detail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.ameerhamza.cryptopedia.common.Constants
import me.ameerhamza.cryptopedia.common.Resource
import me.ameerhamza.cryptopedia.domain.model.Coin
import me.ameerhamza.cryptopedia.domain.use_case.get_coin.GetCoinUseCase
import me.ameerhamza.cryptopedia.domain.use_case.get_coins.GetCoinsUseCase
import me.ameerhamza.cryptopedia.presentation.coin_detail.ui_state.CoinDetailState
import me.ameerhamza.cryptopedia.presentation.coin_list.ui_state.CoinListState

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.COIN_ID)?.let {
            getCoin(it)
        }
    }

    private fun getCoin(coinId: String) {

        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        error = result.message ?: "An Unexpected error occurred."
                    )
                }
            }
        }.launchIn(viewModelScope)

    }

}