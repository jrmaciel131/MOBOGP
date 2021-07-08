package com.example.lista_de_tarefas_app09;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.RvTarefas)

        val lista = mutableListOf<Tarefa>(
            Tarefa(tarefa="HelloWorld", aula= Aula.AULA01, dificuldade= Dificuldade.FACIL),
            Tarefa(tarefa="Sorteio de Números", aula= Aula.AULA02, dificuldade= Dificuldade.FACIL),
            Tarefa(tarefa="Tabuada", aula= Aula.AULA02, dificuldade= Dificuldade.MEDIO),
            Tarefa(tarefa="Álcool e Gasolina", aula= Aula.AULA03, dificuldade= Dificuldade.MEDIO),
            Tarefa(tarefa="Cadastro com Câmera", aula= Aula.AULA04, dificuldade= Dificuldade.FACIL),
            Tarefa(tarefa="ShortBio", aula= Aula.AULA04, dificuldade= Dificuldade.DIFICIL),
            Tarefa(tarefa="Listar Usuários", aula= Aula.AULA05, dificuldade= Dificuldade.MEDIO),
            Tarefa(tarefa="Listar Pets", aula= Aula.AULA05, dificuldade= Dificuldade.MEDIO),
            Tarefa(tarefa="Listar Tarefas", aula= Aula.AULA05, dificuldade= Dificuldade.MEDIO),
        )

        rv.adapter = TarefaAdapter(lista)
        rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

    }
}
