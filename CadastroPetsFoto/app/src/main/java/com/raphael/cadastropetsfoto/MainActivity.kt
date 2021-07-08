package com.raphael.cadastropetsfoto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var petAdapter: PetAdapter
    lateinit var btnIncluir: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle(R.string.titulo_lista)

        val rv = findViewById<RecyclerView>(R.id.rvPets)
        petAdapter = PetAdapter(lista, this)
        btnIncluir = findViewById(R.id.btnIncluir)

        rv.adapter = petAdapter

        btnIncluir.setOnClickListener() {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
        rv.layoutManager = LinearLayoutManager(this)
    }
    companion object {
        val lista = mutableListOf<Pet>()
    }
    override fun onResume() {
        super.onResume()
        petAdapter.notifyDataSetChanged()
    }
}