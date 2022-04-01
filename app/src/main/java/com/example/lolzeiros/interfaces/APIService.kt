package com.example.lolzeiros.interfaces

import retrofit2.Invocation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    fun getSummoner(@Url url:String): Response<Invocation>
}