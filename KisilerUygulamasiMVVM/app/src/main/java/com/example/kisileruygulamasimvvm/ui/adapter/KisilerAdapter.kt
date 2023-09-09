package com.example.kisileruygulamasimvvm.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasimvvm.data.entity.Kisiler
import com.example.kisileruygulamasimvvm.databinding.CardTasarimBinding
import com.example.kisileruygulamasimvvm.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(val mContext: Context,val kisilerListe:List<Kisiler>):RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(binding: CardTasarimBinding):RecyclerView.ViewHolder(binding.root){
        var binding: CardTasarimBinding
        init {
            this.binding=binding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater=LayoutInflater.from(mContext)
        val binding=CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(binding)

    }

    override fun getItemCount(): Int {
        return kisilerListe.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi=kisilerListe.get(position)
        val t=holder.binding
        t.textViewkisiBilgi.text="${kisi.kisiAd} - ${kisi.kisiTel}"
        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisiAd} silinsin mi",Snackbar.LENGTH_LONG).setAction("EVET"){
                Log.e("kişi sil",kisi.kisiId.toString())
            }.show()
        }
        t.satirCard.setOnClickListener{
            val gecis=AnasayfaFragmentDirections.kisiDetayGecis(kisi)
            Navigation.findNavController(it).navigate(gecis)
        }
    }
}