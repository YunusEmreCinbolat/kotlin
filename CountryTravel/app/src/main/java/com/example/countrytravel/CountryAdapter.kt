package com.example.countrytravel

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.countrytravel.databinding.CardItemBinding

class CountryAdapter(private var mContext: Context,private val countryList: List<Country>):RecyclerView.Adapter<CountryAdapter.CardTutucu>() {
    class CardTutucu(binding: CardItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTutucu {
        val binding=CardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardTutucu(binding)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CardTutucu, position: Int) {
        val country=countryList.get(position)
        holder.itemView.findViewById<TextView>(R.id.textViewAd).text=country.name
        holder.itemView.findViewById<CardView>(R.id.cv).setOnClickListener {
            var intent= Intent(holder.itemView.context,DetailActivity::class.java)
           Singleton.Ulkeler=country
            holder.itemView.context.startActivity(intent)
        }
    }
}