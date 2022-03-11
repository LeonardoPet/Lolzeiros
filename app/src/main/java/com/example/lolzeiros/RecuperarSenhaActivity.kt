package com.example.lolzeiros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lolzeiros.databinding.ActivityRecuperarSenhaBinding

class RecuperarSenhaActivity : AppCompatActivity() {
    private val activityRecuperarSenhaBinding:ActivityRecuperarSenhaBinding by lazy{
        ActivityRecuperarSenhaBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityRecuperarSenhaBinding.root)

        activityRecuperarSenhaBinding.enviarEmailBt.setOnClickListener {
            startActivity(Intent(this, AutenticacaoAcitivity::class.java))
        }

    }
}