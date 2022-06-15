package com.example.lolzeiros.interfaces

import com.example.lolzeiros.Network.League
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LeagueAPI {
    @GET("lol/league/v4/entries/by-summoner/{summoner}?api_key=RGAPI-3cd3c721-6cdb-4069-bc3d-38306c401198")
    fun getLeague(@Path("summoner") summoner: String): Call<List<League>>

}