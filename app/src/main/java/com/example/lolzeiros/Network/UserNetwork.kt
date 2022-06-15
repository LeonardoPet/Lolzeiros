package com.example.lolzeiros.Network

import com.example.lolzeiros.interfaces.APIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserNetwork {

    val retrofit by lazy {
        Retrofit.Builder()
        //.baseUrl("https://jsonplaceholder.typicode.com/%22")
            .baseUrl("https://br1.api.riotgames.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService::class.java)
    }
}