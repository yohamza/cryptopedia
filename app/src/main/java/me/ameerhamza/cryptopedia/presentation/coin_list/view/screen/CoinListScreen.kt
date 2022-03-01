package me.ameerhamza.cryptopedia.presentation.coin_list.components

import android.widget.ProgressBar
import me.ameerhamza.cryptopedia.R
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import me.ameerhamza.cryptopedia.domain.model.Coin
import me.ameerhamza.cryptopedia.presentation.Screen
import me.ameerhamza.cryptopedia.presentation.coin_list.viewmodel.CoinListViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Text(
                    text = "Cryptopedia",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                )
            }
            items(
                state.coins,
                key = { item: Coin -> item.id }
            ) { coin ->

                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                    }
                )
            }
        } //: LAZYSCOPE
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)

            )
        }
        if (state.isLoading) {

            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.mobile_loading))
            LottieAnimation(composition, modifier = Modifier.align(Alignment.Center), iterations = Int.MAX_VALUE)

//            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}