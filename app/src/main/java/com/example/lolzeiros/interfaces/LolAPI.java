package com.example.lolzeiros.interfaces;

import com.example.lolzeiros.model.Invocador;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LolAPI {
    @GET("lol/summoner/v4/summoners/by-name/{{id}}?api_key=RGAPI-b56fe2aa-4f07-4981-a985-7215fabf5192")
    public Call<Invocador> find(@Path("id") String id);

}
