package me.ameerhamza.cryptopedia.presentation.coin_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import com.google.accompanist.flowlayout.FlowRow
import me.ameerhamza.cryptopedia.data.remote.dto.TeamMember
import me.ameerhamza.cryptopedia.presentation.Screen
import me.ameerhamza.cryptopedia.presentation.coin_detail.viewmodel.CoinDetailViewModel

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        state.coin?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(10.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Image(
                            painter = rememberImagePainter("https://static.coinpaprika.com/coin/${coin.coinId}/logo.png"),
                            contentDescription = null,
                            modifier = Modifier.size(64.dp)
                        )
                        Text(
                            text = "${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier
                                .weight(8f)
                                .align(CenterVertically)
                                .padding(start = 15.dp)
                        )
                        Image(
                            painter = rememberImagePainter(
                                "https://graphs.coinpaprika.com/currency/chart/${coin.coinId}/7d/chart.svg",
                                builder = {
                                    decoder(SvgDecoder(LocalContext.current))
                                }
                            ),
                            contentDescription = null,
                            modifier = Modifier.height(40.dp).padding(start = 10.dp).align(CenterVertically)
                        )

                    } //: HEADER

                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = coin.description ?: "",
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tags?.forEach { tag ->
                            CoinTag(text = tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Team Members",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                }
                coin.teamMembers?.let {
                    items(coin.teamMembers) { teamMember ->
                        TeamListItem(
                            teamMember = teamMember,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)

                        )
                        Divider()
                    }
                }

            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Center)

            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Center))
        }
    }
}