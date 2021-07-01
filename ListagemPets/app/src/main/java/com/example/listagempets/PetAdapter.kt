package com.example.listagempets

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView

class PetAdapter (var listaPet: MutableList<Pet>):RecyclerView.Adapter<PetAdapter.ItemViewHolder>() {

    // Responsável por encontrar os componentes dentro do layout (item_pet) e indicar que o
    //  layout será replicado na Recycler View
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val txtNome: TextView = view.findViewById(R.id.txtNome)
        val txtEspecie: TextView = view.findViewById(R.id.txtEspecie)
        val txtIdade: TextView = view.findViewById(R.id.txtIdade)
    }

    // Responsável por inflar (fazer aparecer) o layout por exemplo na activity ou fragment ou dialog (tudo que extends View Group)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
        return ItemViewHolder(view)
    }

    // Vincula os componentes do layout (item_pet) a um dado/propriedade/atributo da lista
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaPet[position].foto?.let{
            holder.imgFoto.setImageDrawable(it)
        }
        holder.txtNome.text = listaPet[position].nome
        holder.txtEspecie.text = listaPet[position].especie.nome
        holder.txtIdade.text = listaPet[position].idade

    }

    // Indica quantos registros/itens a lista possui
    override fun getItemCount(): Int {
        return listaPet.size
    }
}
