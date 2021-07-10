package com.example.lista_de_compras_rbd_sp_app16

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Compra::class), version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun compraDao():CompraDAO
}