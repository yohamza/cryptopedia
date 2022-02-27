package me.ameerhamza.cryptopedia.presentation

sealed class Screen(val route: String){
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
}
