package com.example.listagempets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvPets)

        val lista = mutableListOf<Pet>(
            Pet(nome ="Mia", dono ="Raphael", especie = Especie.GATO, idade = "2"+Idade.ANOS, foto =resources.getDrawable(R.drawable.gato)),
            Pet(nome ="Roger", dono ="Cesar", especie = Especie.CACHORRO, idade = "1"+Idade.MES, foto =resources.getDrawable(R.drawable.cachorro)),
            Pet(nome ="Rex", dono ="André", especie = Especie.MACACO, idade = "1"+Idade.ANO, foto =resources.getDrawable(R.drawable.macaco))
        )

        rv.adapter = PetAdapter(lista)

        // Exibe os itens em uma coluna única no padrão vertical
        rv.layoutManager = LinearLayoutManager(this)

        // Exibe os itens em uma coluna única no padrão horizontal
        // rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Exibe os itens em uma tabela com x colunas
        // rv.layoutManager = GridLayoutManager(this, 2)

        // Exibe os itens em uma tabela porém as células são ajustadas automaticamente de acordo com o conteúdo (Google Keep, Pintrest)
        // rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    }
}