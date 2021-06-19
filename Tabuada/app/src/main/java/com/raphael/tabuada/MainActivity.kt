package com.raphael.tabuada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.EditText
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun calcular(v: View){

        var text : String = ""
        var value = findViewById(R.id.valorTabuada) as EditText
        var i : Int =  value.text.toString().toInt()
        var j : Int =  1

        while (j <= 10){
            text += "${i} x ${j} = ${i * j} \n"
            j++
        }

        var texto = findViewById(R.id.tabuada) as TextView;
        texto.setText(text);

    }
}