package com.example.lolzeiros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.lolzeiros.Network.League

import com.example.lolzeiros.Network.User
import com.example.lolzeiros.databinding.ActivityPesquisaEstatisticasBinding
import com.example.lolzeiros.interfaces.APIService
import com.example.lolzeiros.interfaces.LeagueAPI

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


import retrofit2.Retrofit

import retrofit2.converter.moshi.MoshiConverterFactory

//
class PesquisaEstatisticasActivity : AppCompatActivity() {

    companion object {
        const val URL_RIOT_API = "https://br1.api.riotgames.com/"
    }

    private val activityPesquisaEstatisticasBinding: ActivityPesquisaEstatisticasBinding by lazy {
        ActivityPesquisaEstatisticasBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa_estatisticas)
        setContentView(activityPesquisaEstatisticasBinding.root)

        val retro = Retrofit.Builder()
            .baseUrl(URL_RIOT_API)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()


        val service = retro.create(APIService::class.java)
        val service2 = retro.create(LeagueAPI::class.java)

        activityPesquisaEstatisticasBinding.PesquisarBt.setOnClickListener {

            val usuario = activityPesquisaEstatisticasBinding.InvocadorEt.text.toString()
            val call: Call<User> = service.getUser(usuario)
            call.enqueue(object : Callback<User?> {
                override fun onResponse(call: Call<User?>, response: Response<User?>) {
                    val statusCode = response.code()
                    val user = response.body()
                    if (user != null) {
                        activityPesquisaEstatisticasBinding.nome.text = user.name
                        Log.v("SummonerName", user.name)

                        activityPesquisaEstatisticasBinding.SummonerLevel.text = user.summonerLevel.toString()
                        Log.v("SummonerLevel", user.summonerLevel.toString())

                        activityPesquisaEstatisticasBinding.NameSummoner.text = user.accountId
                        Log.v("AccountId", user.accountId)

                        val summoner = user.id

                        //SEGUNDA REQUISIÇÃO
                        if(summoner != null) {

                            val call3: Call<List<League>> = service2.getLeague(summoner)
                            call3.enqueue(object : Callback<List<League>> {

                                override fun onResponse(
                                    call: Call<List<League>>,
                                    response: Response<List<League>>
                                ) {
                                    val statusCode = response.code()
                                    val league = response.body()

                                    activityPesquisaEstatisticasBinding.Tier.text = league!![0].tier

                                    activityPesquisaEstatisticasBinding.Rank.text = league!![0].rank

                                    activityPesquisaEstatisticasBinding.Vitorias.text = league!![0].wins.toString()

                                    activityPesquisaEstatisticasBinding.Derrotas.text = league!![0].losses.toString()

                                }

                                override fun onFailure(call: Call<List<League>>, t: Throwable) {
                                    TODO("Not yet implemented")
                                }
                                ////----

                            })

                        }
                        //FIM DA SEGUNDA REQUISIÇÃO
                    }
                }

                override fun onFailure(call: Call<User?>, t: Throwable) {
                    // Log error here since request failed
                    Log.v("Error", "Um erro ocorreu...")
                }
            })


        }




    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId){
        R.id.sairMi ->{
        AutenticacaoFirebase.firebaseAuth.signOut()
        finish()
        true
        }
     else -> {false}
    }
}
