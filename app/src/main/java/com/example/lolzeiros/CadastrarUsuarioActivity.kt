package com.example.lolzeiros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lolzeiros.databinding.ActivityCadastrarUsuarioBinding

class CadastrarUsuarioActivity : AppCompatActivity() {
    private val activityCadastrarUsuarioBinding:ActivityCadastrarUsuarioBinding by lazy{
        ActivityCadastrarUsuarioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityCadastrarUsuarioBinding.root)

        activityCadastrarUsuarioBinding.cadastroUsuarioBt.setOnClickListener {
            startActivity(Intent(this, AutenticacaoAcitivity::class.java))
        }

    }
}