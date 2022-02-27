package me.ameerhamza.cryptopedia.domain.use_case.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.ameerhamza.cryptopedia.common.Resource
import me.ameerhamza.cryptopedia.data.remote.dto.toCoin
import me.ameerhamza.cryptopedia.domain.model.Coin
import me.ameerhamza.cryptopedia.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }
        catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        }
        catch (e: IOException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Please check your internet connection and try again."))
        }

    }

}