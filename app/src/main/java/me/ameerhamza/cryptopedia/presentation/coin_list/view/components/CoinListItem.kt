package me.ameerhamza.cryptopedia.presentation.coin_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import me.ameerhamza.cryptopedia.domain.model.Coin
import me.ameerhamza.cryptopedia.presentation.ui.theme.ColorPrimary

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row {
            Image(
                painter = rememberImagePainter(
                    "https://static.coinpaprika.com/coin/${coin.id}/logo.png",
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Text(
                text = "${coin.name} (${coin.symbol})",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 15.dp)
            )
        }

        Image(
            painter = rememberImagePainter(
                "https://graphs.coinpaprika.com/currency/chart/${coin.id}/7d/chart.svg",
                builder = {
                    crossfade(true)
                    decoder(SvgDecoder(LocalContext.current))
                }
            ),
            contentDescription = null,
            modifier = Modifier.height(32.dp)
        )

//        Text(
//            text = if(coin.isActive) "active" else "inactive",
//            fontStyle = FontStyle.Italic,
//            style = MaterialTheme.typography.body2,
//            color = if(coin.isActive) ColorPrimary else Color.Red,
//            modifier = Modifier
//                .align(Alignment.CenterVertically)
//        )
    }
}