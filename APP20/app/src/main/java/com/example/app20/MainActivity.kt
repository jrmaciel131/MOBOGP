package com.example.app20


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.app20.domain.GitService
import com.example.app20.util.Network
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {

    private lateinit var campoGIT: EditText
    private lateinit var botaoGIT: Button
    private lateinit var respostaGIT: TextView
    private lateinit var carregamentoGIT : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoGIT = findViewById(R.id.edtGIT)
        botaoGIT = findViewById(R.id.btnBuscarGIT)
        respostaGIT = findViewById(R.id.txtGITResponse)
        carregamentoGIT = findViewById(R.id.prgLoading)



        botaoGIT.setOnClickListener {
            val git = campoGIT.text.toString()
            if(git.isNotEmpty()){
                buscarUsuario(git)
            } else {
                campoGIT.error = "Digite um GIT válido"
            }
        }
    }

    fun buscarUsuario(login: String){
        val retrofitClient = Network.retrofitConfig("https://api.github.com/users/")
        val servico = retrofitClient.create(GitService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = servico.buscarUsuario(login)

                withContext(Dispatchers.Main){
                    changeLoadingVisibility(isVisible = true)
                    delay(2000L)
                    if(response.isSuccessful){
                        changeLoadingVisibility(isVisible = false)
                        respostaGIT.text = response.body().toString()
                    }
                }
            }catch (e: Exception){
                withContext(Dispatchers.Main){
                    changeLoadingVisibility(isVisible = false)
                    respostaGIT.text = "Não foi possível processar a sua solicitação."
                }
            }
        }
    }

    fun changeLoadingVisibility(isVisible: Boolean){
        if(isVisible){
            respostaGIT.text = ""
            carregamentoGIT.visibility = View.VISIBLE
            botaoGIT.visibility = View.INVISIBLE

        } else {
            carregamentoGIT.visibility = View.VISIBLE
            botaoGIT.visibility = View.INVISIBLE
        }
    }
}