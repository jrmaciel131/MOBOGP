package com.example.aulaintentfoto

import android.os.Parcelable


@Parcelize
data class Usuario(val nome: String, val idade: Int) : Parcelable
