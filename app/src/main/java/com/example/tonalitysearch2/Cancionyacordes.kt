package com.example.tonalitysearch2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Cancionyacordes (context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table tabla1(codigo int primary key , cancion text, acordes text) ")
        db?.execSQL("create table tabla2(codigo int ,autor text, codigoautor int)")
        db?.execSQL("create table tabla3(codigo int,cancion text,tonalidad text)")
    }


    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        //db?.execSQL("drop table if exists tabla1")
        //db?.execSQL("drop table if exists tabla2")

    }
}