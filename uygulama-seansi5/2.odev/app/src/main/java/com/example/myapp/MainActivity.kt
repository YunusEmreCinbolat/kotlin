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
        binding.buttondetay1.setOnClickListener {
            val sayfa= Intent(this,detayBirActivity::class.java)
            startActivity(sayfa)
        }
        binding.buttondetay2.setOnClickListener {
            val sayfa= Intent(this,detayIkiActivity::class.java)
            startActivity(sayfa)
        }
        binding.buttondetay3.setOnClickListener {
            val sayfa= Intent(this,DetayUcActivity::class.java)
            startActivity(sayfa)
        }
        binding.buttondetay4.setOnClickListener {
            val sayfa= Intent(this,DetayDortActivity::class.java)
            startActivity(sayfa)
        }
    }
}