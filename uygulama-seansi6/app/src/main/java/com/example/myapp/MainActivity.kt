package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val girdi=binding.girdi.text.toString()
        binding.button.setOnClickListener {
            val intent= Intent(this,MainActivity2::class.java)
            intent.putExtra("KEY",girdi)
            startActivity(intent)
        }
    }
}