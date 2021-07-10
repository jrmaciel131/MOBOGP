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

        configureGITMask()

        botaoGIT.setOnClickListener {
            val git = campoGIT.text.toString()
            if(git.isNotEmpty()){
                buscarGIT(git)
            } else {
                campoGIT.error = "Digite um GIT válido"
            }
        }
    }

    fun buscarGIT(git: String){
        val retrofitClient = Network.retrofitConfig("https://api.github.com/users/")
        val servico = retrofitClient.create(GitService::class.java)

        CoroutineScope(IO).launch {
            try {
                val response = servico.buscarCEP(git.replace( "-", ""))

                withContext(Main){
                    changeLoadingVisibility(isVisibile = true)
                    delay(2000L)
                    if(response.isSuccessful){
                        changeLoadingVisibility(isVisibile = false)
                        respostaGIT.text = response.body().toString()
                    }
                }

            } catch (e: Exception){
                withContext(Main){
                    changeLoadingVisibility(isVisibile = false)
                    respostaGIT.text = "Não foi possível processar a sua solicitação."
                }
            }
        }
    }

    fun configureGITMask(){
        campoGIT.addTextChangedListener(object : TextWatcher {
            var isUpdating: Boolean = false
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val str = s.toString().replace("-", "")
                var mascara = ""
                val mask = "#####-###"
                if (isUpdating) {
                    isUpdating = false
                    return
                }
                var i = 0
                for (m in mask.toCharArray()) {
                    if (m != '#' && count > before) {
                        mascara += m
                        continue
                    }
                    try {
                        mascara += str[i]
                    } catch (e: Exception) {
                        break
                    }
                    i++
                }
                isUpdating = true
                campoGIT.setText(mascara)
                campoGIT.setSelection(mascara.length)
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    fun changeLoadingVisibility(isVisibile: Boolean){
        if(isVisibile){
            respostaGIT.text = ""
            carregamentoGIT.visibility = View.VISIBLE
            botaoGIT.visibility = View.INVISIBLE
        } else {
            carregamentoGIT.visibility = View.INVISIBLE
            botaoGIT.visibility = View.VISIBLE
        }
    }
}

