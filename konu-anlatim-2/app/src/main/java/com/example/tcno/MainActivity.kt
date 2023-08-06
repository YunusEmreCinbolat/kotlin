package com.example.tcno

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tcno.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    public lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val istc=isEditTextEmpty(binding.editTextTc)
        val isAd=isEditTextEmpty(binding.editTextAd)
        val isSoyad=isEditTextEmpty(binding.editTextSoyad)

        setContentView(binding.root)
        binding.button.setOnClickListener{  if(!isAd || !isSoyad || !istc){
                showToast("Tebrikler boş alan yok")
        }
        else{
            val yenintent=Intent(this,RegisterActivity2::class.java)
            startActivity(yenintent)
        }
        }



    }
    private fun isEditTextEmpty(editText: EditText): Boolean {
        return editText.text.trim().isEmpty()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}