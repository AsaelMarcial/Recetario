package com.example.appejemplosqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase.CursorFactory

class AdminSQLite (context:Context, name:String, factory:CursorFactory?, version:Int): SQLiteOpenHelper (context,name,factory,version){

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table receta (tipo int, nombre text, descripcion text, ingredientes text, preparacion text, video text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


}