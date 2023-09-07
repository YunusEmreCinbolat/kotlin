package com.example.cocukeglence

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class IceriklerAdapter(private val mContext: Context,private val iceriklerListe:List<Icerikler>):RecyclerView.Adapter<IceriklerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: View):RecyclerView.ViewHolder(tasarim){
        var icerik_card:CardView
        var textViewicerikAd:TextView
        var imageViewicerikResim:ImageView
        init {
            icerik_card=tasarim.findViewById(R.id.icerik_card)
            textViewicerikAd=tasarim.findViewById(R.id.textViewicerikBaşlık)
            imageViewicerikResim=tasarim.findViewById(R.id.imageViewicerikResim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim=LayoutInflater.from(mContext).inflate(R.layout.icerik_card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return iceriklerListe.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val icerik=iceriklerListe.get(position)
        holder.textViewicerikAd.text=icerik.icerik_ad
        holder.imageViewicerikResim.setImageResource(mContext.resources.getIdentifier(icerik.icerik_resim,"drawable",mContext.packageName))
        holder.icerik_card.setOnClickListener {

        }
    }
}