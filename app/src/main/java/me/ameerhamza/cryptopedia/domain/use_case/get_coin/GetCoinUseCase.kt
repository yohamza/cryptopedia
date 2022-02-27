package me.ameerhamza.cryptopedia.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.ameerhamza.cryptopedia.common.Resource
import me.ameerhamza.cryptopedia.data.remote.dto.toCoin
import me.ameerhamza.cryptopedia.data.remote.dto.toCoinDetail
import me.ameerhamza.cryptopedia.domain.model.Coin
import me.ameerhamza.cryptopedia.domain.model.CoinDetail
import me.ameerhamza.cryptopedia.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading<CoinDetail>())
            val coins = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coins))
        }
        catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(message = e.localizedMessage ?: "An unexpected error occurred"))
        }
        catch (e: IOException) {
            emit(Resource.Error<CoinDetail>(message = e.localizedMessage ?: "Please check your internet connection and try again."))
        }

    }

}