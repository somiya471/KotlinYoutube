package com.example.kotlinyoutube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val name = ArrayList<String>()
    val desc = ArrayList<String>()
    val imageid = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DBHelper(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        db.addVideos("enna_sona","Enna Sona..from Ok Jaanu Movie",R.drawable.enna_sona);
        db.addVideos("hawayein","Hawayein..from Jab Harry Met Sejal",R.drawable.hawayein);
        db.addVideos("ishq_bulava","Ishq Bulava..from Hasee Toh Fasee",R.drawable.hasee);
        db.addVideos("jab_mila_tu","Jab Mila Tu..from I Hate Luv Story",R.drawable.jabmilatu);
        db.addVideos("pani_da","Pani Da Rang..from Vicky Donor",R.drawable.pani_da);

        val adapter = RecyclerAdapter(this,name,desc,imageid)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        displaydata()



}
    fun displaydata(){
        val db = DBHelper(this)
        val cursor = db.getData()
        if(cursor.count==0){
            Toast.makeText(this,"No entry exist",Toast.LENGTH_LONG).show()
            return
        }
        else{
            while (cursor.moveToNext()){
                name.add(cursor.getString(0))
                desc.add(cursor.getString(1))
                imageid.add(cursor.getInt(2))

            }


        }
    }
}