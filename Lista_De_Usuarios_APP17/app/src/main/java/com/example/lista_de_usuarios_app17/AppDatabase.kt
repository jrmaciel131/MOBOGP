package com.example.lista_de_usuarios_app17

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Usuario::class), version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun usuarioDao():UsuarioDAO
}