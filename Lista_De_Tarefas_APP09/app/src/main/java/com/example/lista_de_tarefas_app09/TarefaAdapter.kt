package com.example.lista_de_tarefas_app09;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarefaAdapter(var listaTarefa: MutableList<Tarefa>):RecyclerView.Adapter<TarefaAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtTarefa: TextView = view.findViewById(R.id.txtTarefa)
        val txtAula: TextView = view.findViewById(R.id.txtAula)
        val txtDificuldade: TextView = view.findViewById(R.id.txtDificuldade)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefas, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.txtTarefa.text = listaTarefa[position].tarefa
        holder.txtAula.text = listaTarefa[position].aula.nome
        holder.txtDificuldade.text = listaTarefa[position].dificuldade.nome

    }

    override fun getItemCount(): Int {
        return listaTarefa.size
    }
}
