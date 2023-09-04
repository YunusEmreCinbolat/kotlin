package com.example.firebasauthenticationlesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebasauthenticationlesson2.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var  database=FirebaseDatabase.getInstance()
        val refNesne=database.getReference("nesneler")
       /* val nesne = Nesneler("Havuç",9,"Sebze")
        refNesne.push().setValue(nesne)*/
    }
}