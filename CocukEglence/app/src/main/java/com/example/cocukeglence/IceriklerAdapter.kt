package com.example.cocukeglence

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage

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
        // Firebase Storage'dan alınan StorageReference'ı URL'ye dönüştürün
        val storageRef = Firebase.storage.reference.child("resimler")
        val imageRef: StorageReference = storageRef.child(icerik.icerik_resim ?: "")

        imageRef.let { uri ->
            Log.e("aaaaaaaa",uri.toString())
            val imageURL = uri.toString()

            // Glide ile resmi yükleyin
            try {
                Log.e("uri",imageURL)

                Glide.with(mContext)
                    .load(imageURL)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.imageViewicerikResim)
            } catch (e: Exception) {
                Log.e("GlideError", "Error loading image: ${e.message}")
            }

        }

        holder.icerik_card.setOnClickListener {
        Log.e("basildi",icerik.icerik_resim.toString())
        }
    }
}