package com.example.lista_de_compras_rbd_sp_app16

import androidx.room.*

@Entity(tableName = "TB_COMPRAS")
data class Compra(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "Item")
    var item: String,
    @ColumnInfo(name = "Quantidade")
    var quantidade: Int,
)