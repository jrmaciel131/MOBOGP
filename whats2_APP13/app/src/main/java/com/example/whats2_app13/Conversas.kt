package com.example.whats2_app13

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*



class Conversas : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_conversas, container, false)

        val rv = v.findViewById<RecyclerView>(R.id.rvUsuarios)

        val lista = mutableListOf<Usuario>(
            Usuario(nome = "Maria", conversa = "Maria: Bom dia"),
            Usuario(nome="José", conversa = "José: Boa tarde"),
            Usuario(nome = "João", conversa = "João: Boa Noite"),
            Usuario(nome="Pablo", conversa = "Pablo: Escobar"),
            Usuario(nome = "Arsene", conversa ="Arsene: lupin"),
            Usuario(nome="Patrick", conversa = "Patrick: Jane"),
            Usuario(nome = "Jacke", conversa = "Jacke: Peralta"),
            Usuario(nome="Renata", conversa = "Renata: Olá"),
            Usuario(nome = "Fred", conversa = "Fred: GOL"),
            Usuario(nome="Ashe", conversa = "Ashe: Palet"),
            Usuario(nome = "Josivaldo", conversa = "Josivaldo: KKKKk"),
            Usuario(nome="Gildo", conversa = "Gildo: Do Vigor"),


        )
        rv.adapter = UsuarioAdapter(lista)

        rv.layoutManager = LinearLayoutManager(context)

        return v
    }

}