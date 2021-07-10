package com.example.app20.data.model

import com.google.gson.annotations.SerializedName

class GIT (
    @SerializedName("login") val login: String,
    @SerializedName("name")val name: String,
    @SerializedName("followers")val followers: String,
    @SerializedName("following")val following: String,
    @SerializedName("avatar_url")val avatar_url: String,
    @SerializedName("created_at")val created_at: String){
    //Sobrecarga de método
    override fun toString() : String {
        return "Login: $login\nNome:$name\nE Seguidores: $followers\nSeguindo: $following\n Criado em: $created_at /"
    }

}