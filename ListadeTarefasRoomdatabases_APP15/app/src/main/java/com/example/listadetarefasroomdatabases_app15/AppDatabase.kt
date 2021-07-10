package com.example.listadetarefasroomdatabases_app15

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Tarefa::class), version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun tarefaDao():TarefaDAO
}