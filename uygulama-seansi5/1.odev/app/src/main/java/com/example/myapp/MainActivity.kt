package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    public lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.buttonAnasayfa.setOnClickListener {
            val anasayfa= Intent(this,AnasayfaMainActivity::class.java)
            startActivity(anasayfa)
        }
        binding.buttonPortfolyo.setOnClickListener {
            val portfolyo= Intent(this,PortfolyoMainActivity::class.java)
            startActivity(portfolyo)
        }
        binding.buttonAyarlar.setOnClickListener {
            val ayarlar= Intent(this,AyarlarMainActivity::class.java)
            startActivity(ayarlar)
        }
    }
}