package me.ameerhamza.cryptopedia.domain.model

import me.ameerhamza.cryptopedia.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val tags: List<String>,
    val teamMembers: List<TeamMember>?,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean
)
