package com.example.lolzeiros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.lolzeiros.databinding.ActivityAutenticacaoAcitivityBinding


class AutenticacaoAcitivity : AppCompatActivity() {
    private val activityAutenticacaoBinding: ActivityAutenticacaoAcitivityBinding by lazy{
        ActivityAutenticacaoAcitivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityAutenticacaoBinding.root)

        activityAutenticacaoBinding.cadastrarUsuarioBt.setOnClickListener{
            startActivity(Intent(this, CadastrarUsuarioActivity::class.java))
        }
        activityAutenticacaoBinding.recuperarSenhaBt.setOnClickListener{
            startActivity(Intent(this, RecuperarSenhaActivity::class.java))
        }
        activityAutenticacaoBinding.entrarBt.setOnClickListener{
            startActivity(Intent(this, PesquisaEstatisticasActivity::class.java))
        }


    }





}