package com.example.kisileruygulamasi

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class KisiAdapter(val mContext: Context,val kisiList: List<kisiler>): RecyclerView.Adapter<KisiAdapter.KisiTutucu>() {
    inner class KisiTutucu(tasarim: View):RecyclerView.ViewHolder(tasarim) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KisiTutucu {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: KisiTutucu, position: Int) {
        TODO("Not yet implemented")
    }
}