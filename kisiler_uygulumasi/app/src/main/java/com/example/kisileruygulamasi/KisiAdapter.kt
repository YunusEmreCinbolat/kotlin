package com.example.kisileruygulamasi

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KisiAdapter(private val mContext: Context,private val kisiList: List<kisiler>): RecyclerView.Adapter<KisiAdapter.KisiTutucu>() {
    inner class KisiTutucu(val tasarim: View ):RecyclerView.ViewHolder(tasarim){
        val KisiAd_tel:TextView=tasarim.findViewById(R.id.textViewAdTelefon)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KisiTutucu {
        val tasarim=LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false)
        return KisiTutucu(tasarim)
    }

    override fun getItemCount(): Int {
       return kisiList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: KisiTutucu, position: Int) {
       val kisi=kisiList[position]
        holder.KisiAd_tel.text="${kisi.kisi_ad} - ${kisi.kisi_tel}"


    }
}