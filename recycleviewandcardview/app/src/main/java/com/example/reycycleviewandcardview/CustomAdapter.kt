package com.example.reycycleviewandcardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val userList: ArrayList<User>):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>()
{

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tvadsoyad:TextView=view.findViewById(
            R.id.textViewAdSoyad
        )
        val tvYas:TextView=view.findViewById(
            R.id.textViewYas
        )
        val tvhakkimda:TextView=view.findViewById(
            R.id.textViewHakkinda
        )

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.user_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.tvadsoyad.text=userList[position].adSoyad
        holder.tvYas.text=userList[position].yasi
        holder.tvhakkimda.text=userList[position].tanit
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}