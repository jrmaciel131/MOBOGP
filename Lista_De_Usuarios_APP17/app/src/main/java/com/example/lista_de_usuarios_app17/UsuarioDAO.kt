package com.example.lista_de_usuarios_app17

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDAO {
    @Query("SELECT * FROM TB_USUARIOS")
    suspend fun getUsuario(): List<Usuario>

    @Insert
    suspend fun addUsuario(i: Usuario)

    @Delete
    suspend fun deleteUsuario(i: Usuario)
}