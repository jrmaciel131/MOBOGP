package com.example.lista_de_usuarios_app17

import android.graphics.Bitmap
import androidx.room.*
import com.example.lista_de_usuarios_app17.Senioridade
import com.example.lista_de_usuarios_app17.Stack

@Entity(tableName = "TB_USUARIOS")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    /*@ColumnInfo(name = "Foto")
    var foto: Bitmap? = null,*/
    @ColumnInfo(name = "Nome")
    var nome: String,
    @ColumnInfo(name = "Email")
    var email: String,
    @ColumnInfo(name = "Stack")
    var stack: Stack,
    @ColumnInfo(name = "Senioridade")
    var senioridade: Senioridade,
    @ColumnInfo(name = "Empregado")
    var empregado: Boolean
)