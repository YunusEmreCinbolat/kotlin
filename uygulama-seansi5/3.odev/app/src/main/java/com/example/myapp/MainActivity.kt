package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    public lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var ad=binding.editTextAd
        var tc=binding.editTextTc
        binding.buttonGiris.setOnClickListener {
            if(!ad.text.isEmpty() && !tc.text.isEmpty()){
                val anasayfa= Intent(this,HomeActivity::class.java)
                startActivity(anasayfa)
            }
            else{
                Toast.makeText(this,"Eksik bilgi",Toast.LENGTH_LONG).show()
            }
        }
    }
}