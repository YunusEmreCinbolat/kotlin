package com.example.sayacuygulamasi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sayacuygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences=getSharedPreferences("GirişSayacı",Context.MODE_PRIVATE)
        var sayac=sharedPreferences.getInt("sayac",0)
        val editor=sharedPreferences.edit()
        editor.putInt("sayac",++sayac)
        editor.commit()
        binding.textviewSayac.text="Acılış sayısı $sayac"
    }
}