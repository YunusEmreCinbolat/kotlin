package com.example.countrytravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countrytravel.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView( binding.root)
       val country= Singleton.Ulkeler
        country?.let {
            binding.Adtext.text=country.name
            binding.ulkeText.text=country.country
            binding.imageView.setImageResource(country.image)
        }

    }
}