package com.example.lolzeiros.interfaces

import com.example.lolzeiros.Network.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    //@GET("posts/1")
    @GET("lol/summoner/v4/summoners/by-name/{nome}?api_key=RGAPI-3cd3c721-6cdb-4069-bc3d-38306c401198")

    fun getUser(@Path("nome") nome: String): Call<User>

    @GET("posts")
    suspend fun getPosts(): List<User>
}