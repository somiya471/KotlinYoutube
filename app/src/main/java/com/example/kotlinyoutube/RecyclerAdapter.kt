package com.example.kotlinyoutube

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val context: Context,val name:ArrayList<String>,val desc:ArrayList<String>,val imageid:ArrayList<Int>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val img = itemView.findViewById<ImageView>(R.id.img)
        val name_inside = itemView.findViewById<TextView>(R.id.name_inside)
        val desc_inside = itemView.findViewById<TextView>(R.id.desc_inside)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_items,parent,false))

    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.img.setImageResource(imageid[position])
        holder.name_inside.text = name[position]
        holder.desc_inside.text = desc[position]
        holder.itemView.setOnClickListener{
            val iNext = Intent(context,NextActivity::class.java)
            iNext.putExtra("name",name[position].toString())
            iNext.putExtra("desc",desc[position].toString())
            iNext.putExtra("imageid",imageid[position].toString().toInt())
            context.startActivity(iNext)
        }

    }

    override fun getItemCount(): Int {
        return name.size
    }
}