package com.example.sharedpreferenceskullanimi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferenceskullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences=getSharedPreferences("Kişisel Bilgiler", Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        editor.remove("yas")

        editor.commit()

        editor.remove("boy")
        editor.commit()

        editor.remove("ogrenciMi")
        editor.commit()

        editor.remove("arkadasListesi")
        editor.commit()
      /*  editor.putString("ad","Yunus")
        editor.putInt("yas",22)
        editor.putFloat("boy",1.65f)
        editor.putBoolean("ogrenciMi",true)
        val arkadasListesi=HashSet<String>()
        arkadasListesi.add("Fahreddin")
        arkadasListesi.add("Mithat")
        arkadasListesi.add("umit")
        arkadasListesi.add("Ali")
        editor.putStringSet("arkadasListesi",arkadasListesi)
        */editor.commit()
        binding.buttonGit.setOnClickListener {
            startActivity(Intent(this,ActivityDetail::class.java))
        }
    }
}