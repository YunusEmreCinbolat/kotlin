package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var kullaniciList= mutableListOf<User>()
        binding.buttonkaydet.setOnClickListener {
            val adSoyad=binding.editTextTextAdSoyad.text
            val yas=binding.editTextTextYas.text
            val hakkinda=binding.editTextTextHakkNda.text
            if(!adSoyad.isEmpty() && !yas.isEmpty() && !hakkinda.isEmpty()){
                val user=User(adSoyad.toString(),yas.toString(),hakkinda.toString())
                kullaniciList.add(user)

            }
            else{
                Toast.makeText(this,"Veriler boş",Toast.LENGTH_LONG).show()
            }
        }
        binding.buttongoster.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            intent.putParcelableArrayListExtra("userList", ArrayList(kullaniciList))
            startActivity(intent)
        }
    }
}

