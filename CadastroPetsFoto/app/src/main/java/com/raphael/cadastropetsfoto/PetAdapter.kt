package com.raphael.cadastropetsfoto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PetAdapter(var listaPet: MutableList<Pet>, var context: Context): RecyclerView.Adapter<PetAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val txtNome: TextView = view.findViewById(R.id.txtNome)
        val txtCor: TextView = view.findViewById(R.id.txtCor)
        val txtEspecie: TextView = view.findViewById(R.id.txtEspecie)
        val txtSexo: TextView = view.findViewById(R.id.txtSexo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaPet[position].foto?.let{
            holder.imgFoto.setImageBitmap(it)
        }
        holder.txtNome.text = listaPet[position].nome
        holder.txtCor.text = listaPet[position].cor
        holder.txtEspecie.text = listaPet[position].especie.nome
        holder.txtSexo.text = listaPet[position].sexo.nome

        holder.itemView.setOnClickListener(){
            var texto = if (listaPet[position].vacinado) {
                "Pet 100% vacinado!"
            }
            else
            {
                "Pet com vacinas pendentes!"
            }

            Toast.makeText(context, texto, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listaPet.size
    }
}