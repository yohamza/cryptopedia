package me.ameerhamza.cryptopedia.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.ameerhamza.cryptopedia.R

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)

val QuickSand = FontFamily(
    Font(R.font.quicksand_light, FontWeight.W300),
    Font(R.font.quicksand_regular, FontWeight.W400),
    Font(R.font.quicksand_medium, FontWeight.W500),
    Font(R.font.quicksand_bold, FontWeight.W600),
)

val quickSandTypography = Typography(
    h1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = QuickSand,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)