package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.login.databinding.ActivityRegisterMainBinding

class RegisterMainActivity : AppCompatActivity() {
    public lateinit var binding: ActivityRegisterMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val ad=binding.editName
        val soyad=binding.editSoyad
        val sifre=binding.editTextTextSifre
        val sifreTekrar=binding.editTextTextSifreTekrar
        val email=binding.editTextTextEmailAddress
        binding.btnkayit.setOnClickListener { if(!ad.text.isEmpty()|| !soyad.text.isEmpty() || ! sifre.text.isEmpty() || sifreTekrar.text.isEmpty() || !email.text.isEmpty()){
            val girisekran=Intent(this,MainActivity::class.java)
        } else
            Toast.makeText(this,"Yanlis girdi",Toast.LENGTH_LONG).show()
        }
    }
}