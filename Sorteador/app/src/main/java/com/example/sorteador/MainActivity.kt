package com.example.sorteador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var texto: TextView
    lateinit var btn : Button
    var numeroSorteado: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super .onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        texto = findViewById(R.id.txtNumero)
        btn = findViewById(R.id.btnSortear)
        btn.setOnClickListener {
            numeroSorteado = texto.text.toString().toIntOrNull()
            SortearNumero()
        }
    }


    fun SortearNumero(){

        var numeroSorteado = Random().nextInt(11)

        texto.setText("O número é: $numeroSorteado")
    }
}