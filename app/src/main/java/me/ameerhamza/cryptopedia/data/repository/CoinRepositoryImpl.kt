package me.ameerhamza.cryptopedia.data.repository

import me.ameerhamza.cryptopedia.data.remote.api.CoinPaprikaApi
import me.ameerhamza.cryptopedia.data.remote.dto.CoinDetailDto
import me.ameerhamza.cryptopedia.data.remote.dto.CoinDto
import me.ameerhamza.cryptopedia.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}