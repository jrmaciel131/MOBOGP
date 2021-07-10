package com.example.lista_de_usuarios_app17

import android.content.Context
import androidx.room.Room
import com.example.lista_de_usuarios_app17.AppDatabase

object DatabaseBuilder {
    private var instancia: AppDatabase?= null

    fun getAppDatabase(context: Context): AppDatabase?{
        if(instancia == null){
            synchronized(AppDatabase::class){
                instancia =
                    Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "AppDb")
                        .fallbackToDestructiveMigration()
                        .build()
            }
        }
        return instancia
    }
}