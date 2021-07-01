package com.example.listagempets

import android.graphics.drawable.Drawable

data class Pet(
    var foto: Drawable?=null,
    var nome: String,
    var dono: String,
    var especie: Especie,
    var idade: String
)