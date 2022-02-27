package me.ameerhamza.cryptopedia.domain.repository

import me.ameerhamza.cryptopedia.data.remote.dto.CoinDetailDto
import me.ameerhamza.cryptopedia.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto

}