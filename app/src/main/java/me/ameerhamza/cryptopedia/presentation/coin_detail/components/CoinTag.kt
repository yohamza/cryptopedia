package me.ameerhamza.cryptopedia.presentation.coin_detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import me.ameerhamza.cryptopedia.presentation.ui.theme.ColorPrimary

@Composable
fun CoinTag(
    text: String
) {
    Box(
        modifier = Modifier.border(
            width = 1.dp,
            color = ColorPrimary,
            shape = RoundedCornerShape(100.dp),
        )
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(10.dp),
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2
        )
    }
}