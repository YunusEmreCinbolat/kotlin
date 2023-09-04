package com.example.firebasauthenticationlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebasauthenticationlesson.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database=FirebaseDatabase.getInstance()

        val refKisiler=database.getReference("kisiler")

        /*kayıt
        val kisi= Kisiler("ali",5)
        refKisiler.push().setValue(kisi)
         */
        /*silme
        refKisiler.child("-NdUnNvNFK0ztwB2WqA7").removeValue()
        */
        // güncelleme
        val updateInfo=HashMap<String,Any>()
        updateInfo["kisiAd"]="Mehmet"
        updateInfo["kisiYas"]=65
        refKisiler.child("-NdUn3USMRGiiqB-onzu").updateChildren(updateInfo)
        
    }
}