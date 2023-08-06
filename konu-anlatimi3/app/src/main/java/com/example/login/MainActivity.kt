package com.example.login

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val ad = binding.editTextGirisAd
        val sifre = binding.editTextTextGirisSifre

        setContentView(binding.root)
        binding.buttonGiris.setOnClickListener {
            if (!ad.text.isEmpty() || !sifre.text.isEmpty()) {
                val giris = Intent(this, LoginMainActivity::class.java)
                startActivity(giris)
            } else {
                Toast.makeText(this, "Bos alanlar", Toast.LENGTH_LONG).show()
            }
        }
        binding.buttonkayit.setOnClickListener {
            val kayitol = Intent(this, RegisterMainActivity::class.java)
            startActivity(kayitol)
        }

    }
}

