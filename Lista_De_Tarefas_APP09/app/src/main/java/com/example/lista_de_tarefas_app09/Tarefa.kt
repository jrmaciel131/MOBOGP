package com.example.lista_de_tarefas_app09;

import android.graphics.drawable.Drawable

data class Tarefa(
    var foto: Drawable?=null,
    var tarefa: String,
    var aula: Aula,
    var dificuldade: Dificuldade
)

