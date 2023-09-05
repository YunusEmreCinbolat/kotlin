package com.example.cocukeglence

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class KategorilerAdapter(private  val mContext: Context,private val kategoriListe:List<Kategoriler>):RecyclerView.Adapter<KategorilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: View):RecyclerView.ViewHolder(tasarim){
        var kategori_card:CardView
        var textViewKategoriAd:TextView
        init {
            kategori_card=tasarim.findViewById(R.id.kategori_card)
            textViewKategoriAd=tasarim.findViewById(R.id.textViewKategoriAd)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim=LayoutInflater.from(parent.context).inflate(R.layout.kategori_card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return kategoriListe.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kategoriler= kategoriListe.get(position)
        holder.textViewKategoriAd.text=kategoriler.kategori_ad
        holder.kategori_card.setOnClickListener {

        }
    }
}