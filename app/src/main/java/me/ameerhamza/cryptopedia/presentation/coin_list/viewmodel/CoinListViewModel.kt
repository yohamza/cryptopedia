package me.ameerhamza.cryptopedia.presentation.coin_list.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.ameerhamza.cryptopedia.common.Resource
import me.ameerhamza.cryptopedia.domain.model.Coin
import me.ameerhamza.cryptopedia.domain.use_case.get_coins.GetCoinsUseCase
import me.ameerhamza.cryptopedia.presentation.coin_list.ui_state.CoinListState

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {

        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?: "An Unexpected error occurred."
                    )
                }
            }
        }.launchIn(viewModelScope)

    }

}