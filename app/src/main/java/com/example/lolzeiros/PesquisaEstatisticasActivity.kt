package com.example.lolzeiros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.widget.SearchView

import com.example.lolzeiros.interfaces.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PesquisaEstatisticasActivity : AppCompatActivity(), SearchView.OnQueryTextListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa_estatisticas)

        //val buttonPesquisar = findViewById<Button>(R.id.PesquisarBt)

        //val editTextInvocador = findViewById<EditText>(R.id.InvocadorEt)

        //buttonPesquisar.setOnClickListener {
        //    //objeto invocador

        //}


    }
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://br1.api.riotgames.com/lol/summoner/v4/summoners/by-name/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getSummoner("$query?api_key=RGAPI-b56fe2aa-4f07-4981-a985-7215fabf5192")
            val invocadores = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    //show result
                    val teste = invocadores

                } else {
                    //show error
                    showError()
                }
            }
        }
    }

    private fun showError(){
        Toast.makeText(this,"Um erro inesperado ocorreu...", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByName(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}