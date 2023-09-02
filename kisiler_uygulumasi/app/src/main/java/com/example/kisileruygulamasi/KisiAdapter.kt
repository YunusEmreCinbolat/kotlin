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

class KisiAdapter(private val mContext: Context,private val kisiList: List<kisiler>): RecyclerView.Adapter<KisiAdapter.KisiTutucu>() {
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
                      Snackbar.make(it,"Silinsin mi",Snackbar.LENGTH_LONG).setAction("Evet"){}.show()
                        true
                    }
                    else -> false
                }


            }
            popupMenu.show()
        }


    }
     fun showAlert(user: kisiler){
        val design=LayoutInflater.from(mContext).inflate(R.layout.alert_design,null)
        val editTextName=design.findViewById(R.id.name_et) as EditText
        val  editTextphone=design.findViewById(R.id.phone_et) as EditText

        editTextName.setText(user.kisi_ad)
        editTextphone.setText(user.kisi_tel)

            val alertDialog=AlertDialog.Builder(mContext)
            alertDialog.setTitle("Kisi Güncelle")
            alertDialog.setView(design)
            alertDialog.setPositiveButton("Güncelle"){dialogInterface,i ->
                val name = editTextName.text.toString().trim()
                val phone=editTextphone.text.toString().trim()
                Toast.makeText(mContext,"$name - $phone ",Toast.LENGTH_LONG).show()
            }
            alertDialog.setNegativeButton("İptal"){ dialogInterface, i ->

            }
            alertDialog.create().show()
    }

}