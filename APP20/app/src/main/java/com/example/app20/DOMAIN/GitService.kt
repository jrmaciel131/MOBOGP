package com.example.app20.domain

import com.example.app20.data.model.GIT
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface GitService {


    @GET("{loginInserido}")
    suspend fun buscarUsuario(
        @Path("loginInserido") git: String
    ) : Response<GIT>
}