package com.example.myapplication

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val users: ArrayList<String>): RecyclerView.Adapter<UserAdapter.UserTutucu>() {

     class UserTutucu(itemview:View): RecyclerView.ViewHolder(itemview){

             val tvadsoyad: TextView =itemView.findViewById(
                 R.id.textViewAdSoyad
             )



     }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserTutucu {
       val itemview=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return UserTutucu(itemview)
    }

    override fun onBindViewHolder(holder: UserTutucu, position: Int) {
        holder.tvadsoyad.text=users[position]

    }

    override fun getItemCount(): Int {
        return users.size
    }


}