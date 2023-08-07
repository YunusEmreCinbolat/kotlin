package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bosmuAd=binding.editTextAd
        val bosmuTelefon=binding.editTextTelefon
        binding.buttonkaydet.setOnClickListener {
            if(!bosmuAd.text.isEmpty() || !bosmuTelefon.text.isEmpty()){
                val kaydet=Intent(this,KayitActivity::class.java)
                startActivity(kaydet)
            }
            else{
                Toast.makeText(this,"Bos alanlari doldurun",Toast.LENGTH_LONG).show()
            }
        }

    }
}