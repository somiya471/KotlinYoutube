package com.example.kotlinyoutube

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):
SQLiteOpenHelper(context,"YoutubePlay",null,1){
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table YTPlaylist(name text primary key,descr text,imageid int)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists YTPlaylist")
        onCreate(db)
    }

    fun addVideos(name:String,descr:String,imageid:Int){
        val db = this.writableDatabase
        val values = ContentValues()

        values.put("name",name)
        values.put("descr",descr)
        values.put("imageid",imageid)
        db.insert("YTPlaylist",null,values)
        db.close()

    }

    fun getData():Cursor{
        val db = this.readableDatabase
        return db.rawQuery("Select * from YTPlaylist",null)
    }
}