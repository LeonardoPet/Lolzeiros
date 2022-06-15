package com.example.lolzeiros.Network

data class User(
    val id: String,
    val accountId: String,
    val puuid: String,
    val name: String,
    val profileIconId: Int,
    val revisionDate: Double,
    val summonerLevel: Int
)