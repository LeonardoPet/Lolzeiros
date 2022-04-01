package com.example.lolzeiros.model

import com.google.gson.annotations.SerializedName

data class Invocation (
    @SerializedName("name") var name: String,
    @SerializedName("summonerLevel") var summonerLevel:String
    )