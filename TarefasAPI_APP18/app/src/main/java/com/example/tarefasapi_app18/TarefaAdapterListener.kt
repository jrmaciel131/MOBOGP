package com.example.tarefasapi_app18

import com.example.tarefasapi_app18.data.model.Tarefa

interface TarefaAdapterListener {
    fun excluirTarefa(tarefa: Tarefa)
}
