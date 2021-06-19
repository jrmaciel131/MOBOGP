package com.example.gasolinaxalcool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var valor1: EditText
    lateinit var valor2: EditText
    lateinit var result: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        valor1 = findViewById(R.id.va)
        valor2 = findViewById(R.id.vg)
        result = findViewById(R.id.result)

    }
    fun CalcularAlcool(view: View) {
        var valor1 : Double =  valor1.text.toString().toDouble()
        var valor2 : Double =  valor2.text.toString().toDouble()

        var r : Double = (valor1/valor2)

        if (r > 0.7){
            result.setText("Utilize Gasolina!")
        }   else{
            result.setText("Utilize Alcool!")
        }

    }
}