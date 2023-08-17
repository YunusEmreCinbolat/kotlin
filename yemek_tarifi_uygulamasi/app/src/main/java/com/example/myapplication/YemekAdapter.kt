package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ListItemBinding

class YemekAdapter(private val mcontext: Context, private val yemekListesi:ArrayList<Yemekler>):RecyclerView.Adapter<YemekAdapter.yemektutucu>() {
    inner class yemektutucu(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): yemektutucu {
        val binding=ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return yemektutucu(binding)
    }

    override fun getItemCount(): Int {
        return yemekListesi.size
    }

    override fun onBindViewHolder(holder: yemektutucu, position: Int) {
        val yemekler=yemekListesi[position]
        val binding=holder.binding
        binding.textViewAd.text=yemekler.ad
        val yemekId=mcontext.resources.getIdentifier(yemekler.resimAd,"drawable",mcontext.packageName)
        binding.imageView.setImageResource(yemekId)
    }
}