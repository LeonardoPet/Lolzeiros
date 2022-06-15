package com.example.lolzeiros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.example.lolzeiros.databinding.ActivityAutenticacaoAcitivityBinding


class AutenticacaoActivity : AppCompatActivity() {
    private val activityAutenticacaoActivity: ActivityAutenticacaoAcitivityBinding by lazy{
        ActivityAutenticacaoAcitivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityAutenticacaoActivity.root)
        supportActionBar?.subtitle = "Autenticação"

        with(activityAutenticacaoActivity){
            cadastrarUsuarioBt.setOnClickListener{
                startActivity(Intent(this@AutenticacaoActivity, com.example.lolzeiros.CadastrarUsuarioActivity::class.java))
            }
            recuperarSenhaBt.setOnClickListener{
                startActivity(Intent(this@AutenticacaoActivity, RecuperarSenhaActivity::class.java))
            }
            entrarBt.setOnClickListener{
                val email = EmailEt.text.toString()
                val senha = senhaEt.text.toString()
                AutenticacaoFirebase.firebaseAuth.signInWithEmailAndPassword(email, senha).addOnSuccessListener {
                    iniciarPesquisaEstatisticasActivity()
                    finish()
                }.addOnFailureListener {
                    Toast.makeText(this@AutenticacaoActivity, "Usuário/senha incorretos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(AutenticacaoFirebase.firebaseAuth.currentUser != null){
            iniciarPesquisaEstatisticasActivity()
        }
    }

    private fun iniciarPesquisaEstatisticasActivity(){
        startActivity(Intent(this@AutenticacaoActivity, PesquisaEstatisticasActivity::class.java))
        finish()
    }

}