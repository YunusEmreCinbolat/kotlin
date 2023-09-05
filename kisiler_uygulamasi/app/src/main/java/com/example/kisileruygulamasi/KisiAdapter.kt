package com.example.kisileruygulamasi

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.databinding.ListItemBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference

class KisiAdapter(private val mContext: Context,private val kisiList: List<kisiler>,private val refkisiler: DatabaseReference): RecyclerView.Adapter<KisiAdapter.KisiTutucu>() {
    inner class KisiTutucu(val binding: ListItemBinding ):RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KisiTutucu {
       val binding =ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return KisiTutucu(binding)
    }

    override fun getItemCount(): Int {
       return kisiList.size
    }


    override fun onBindViewHolder(holder: KisiTutucu, position: Int) {
       val kisi=kisiList[position]
        val binding=holder.binding
        binding.textViewAdTelefon.text="${kisi.kisi_ad} - ${kisi.kisi_tel}"
        binding.imageViewMore.setOnClickListener {
            val popupMenu=PopupMenu(mContext,binding.imageViewMore)
            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                menuItem ->
                when(menuItem.itemId){
                    R.id.KisiGuncelle ->{
                        showAlert(kisi)
                        true
                    }
                    R.id.KisiSil -> {
                      Snackbar.make(it,"Silinsin mi",Snackbar.LENGTH_LONG).setAction("Evet"){
                          refkisiler.child(kisi.kisi_id!!).removeValue()
                      }.show()
                        true
                    }
                    else -> false
                }


            }
            popupMenu.show()
        }


    }
    private fun showAlert(kisi: kisiler){
        val design= LayoutInflater.from(mContext).inflate(R.layout.alert_design,null)
        val editTextName=design.findViewById(R.id.name_et) as EditText
        val  editTextphone=design.findViewById(R.id.phone_et) as EditText
        editTextName.setText(kisi.kisi_ad)
        editTextphone.setText(kisi.kisi_tel)

        val alertDialog= AlertDialog.Builder(mContext)
        alertDialog.setTitle("Kişi Güncelle")
        alertDialog.setView(design)
        alertDialog.setPositiveButton("Güncelle"){_,_ ->
            val name = editTextName.text.toString().trim()
            val phone=editTextphone.text.toString().trim()
            val bilgiler=HashMap<String,Any>()
            bilgiler.put("kisiAd",name)
            bilgiler.put("kisiler_tel",phone)
            refkisiler.child(kisi.kisi_id!!).updateChildren(bilgiler)
            Toast.makeText(mContext,"$name - $phone ", Toast.LENGTH_LONG).show()
        }
        alertDialog.setNegativeButton("İptal"){ _, _ ->}
        alertDialog.create().show()
    }

}